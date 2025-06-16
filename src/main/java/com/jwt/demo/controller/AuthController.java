package com.jwt.demo.controller;

import com.jwt.demo.Dto.AuthenticationDto;
import com.jwt.demo.Dto.LoginResponseDto;
import com.jwt.demo.Dto.RegisterDto;
import com.jwt.demo.infra.security.TokenService;
import com.jwt.demo.model.Pessoa;
import com.jwt.demo.repository.PessoaRepository;
import com.jwt.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
        if(pessoaRepository.findByLogin(dto.login()) != null ) return ResponseEntity.badRequest().build();

        String senhaEncrpitografada = new BCryptPasswordEncoder().encode(dto.password());
        Pessoa pessoa = new Pessoa( dto.email(), senhaEncrpitografada, dto.login(), dto.role());

        pessoaRepository.save(pessoa);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDto dto) {
        var user = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(user);
        var token = tokenService.generateToken((Pessoa)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}