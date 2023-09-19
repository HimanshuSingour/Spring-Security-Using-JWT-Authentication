package com.jwt.auth.security.JWT.Security.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtRequest {

    private String userName;
    private String password;
}
