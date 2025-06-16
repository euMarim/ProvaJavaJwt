package com.jwt.demo.Dto;

import com.jwt.demo.model.EnumRole;
import com.jwt.demo.model.Pessoa;

public class PessoaDto {
    private long id;
    private String password;
    private String login;
    private EnumRole role;

    public PessoaDto(String password, String login, EnumRole role) {
        this.password = password;
        this.login = login;
        this.role = role;
    }

    public Pessoa ToModel(){
        return new Pessoa(password, login ,role);
    }

    public PessoaDto() {
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }
}