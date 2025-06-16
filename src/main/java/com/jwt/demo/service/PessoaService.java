package com.jwt.demo.service;

import com.jwt.demo.model.Pessoa;
import com.jwt.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements UserDetailsService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return pessoaRepository.findByLogin(username);
    }

    public Pessoa editarUsuario(long id, Pessoa pessoa){
        Pessoa pessoaDoBanco = pessoaRepository.findById(id).orElseThrow();

        if(pessoa.getLogin() != null && pessoa.getLogin() != ""){
            pessoaDoBanco.setLogin(pessoa.getLogin());
        }

        if(pessoa.getPassword() != null  && pessoa.getLogin() != ""){
            String senhaEncrpitografada = new BCryptPasswordEncoder().encode(pessoa.getPassword());
            pessoaDoBanco.setPassword(senhaEncrpitografada);
        }

        return pessoaRepository.save(pessoaDoBanco);
    }

    public Pessoa buscarPorId(long id){
        return pessoaRepository.findById(id).orElseThrow();
    }

    public String deletar(long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();

        pessoaRepository.delete(pessoa);
        return "Pessoa removida com sucesso!";
    }

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }
}
