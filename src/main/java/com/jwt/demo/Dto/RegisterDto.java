package com.jwt.demo.Dto;

import com.jwt.demo.model.EnumRole;

public record RegisterDto (String login, String password, EnumRole role, String email){
}
