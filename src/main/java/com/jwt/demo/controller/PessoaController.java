package com.jwt.demo.controller;

import com.jwt.demo.Dto.PessoaDto;
import com.jwt.demo.model.Pessoa;
import com.jwt.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PutMapping("editarPerfil")
    ResponseEntity<Pessoa> editarPerfil(@AuthenticationPrincipal Pessoa pessoa, @RequestBody PessoaDto dto){
        return ResponseEntity.ok(pessoaService.editarUsuario(pessoa.getId(), dto.ToModel()));
    }

    @PutMapping("editarPessoa/{id}")
    ResponseEntity<Pessoa> editarPerfil(@PathVariable long id, @RequestBody PessoaDto dto){
        return ResponseEntity.ok(pessoaService.editarUsuario(id, dto.ToModel()));
    }

    @GetMapping("listarTodosUsuarios")
    ResponseEntity<List<Pessoa>> listarTodosUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listar());
    }

    @GetMapping("{id}")
    ResponseEntity<Pessoa> buscarPorId(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPorId(id));
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deletar(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletar(id));
    }

    @GetMapping("visualizarPerfil")
    ResponseEntity<Pessoa> visualizarPerfil(@AuthenticationPrincipal Pessoa pessoa){
        return ResponseEntity.ok(pessoa);
    }
}