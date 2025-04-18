package com.Projet.Jasser.auth.Repositories;

import com.Projet.Jasser.auth.Dtoauth.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String>
{
}
