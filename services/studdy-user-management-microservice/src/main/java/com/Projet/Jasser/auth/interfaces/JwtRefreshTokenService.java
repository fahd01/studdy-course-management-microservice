package com.Projet.Jasser.auth.interfaces;


import com.Projet.Jasser.Entity.User;
import com.Projet.Jasser.auth.Dtoauth.JwtRefreshToken;

public interface JwtRefreshTokenService
{
    JwtRefreshToken createRefreshToken(Long userId);

    User generateAccessTokenFromRefreshToken(String refreshTokenId);
}
