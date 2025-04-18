package com.Projet.Jasser.auth.interfaces;



import com.Projet.Jasser.Entity.User;
import com.Projet.Jasser.Exceptions.EmailNotExist;
import com.Projet.Jasser.Exceptions.ResetPasswordException;
import com.Projet.Jasser.Exceptions.ResetPasswordTokenException;
import com.Projet.Jasser.auth.Dtoauth.PasswordResetToken;
import jakarta.mail.MessagingException;

import java.io.IOException;


public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
	
    PasswordResetToken generatePasswordResetToken(String email) throws EmailNotExist, IOException, java.io.IOException, MessagingException;
	
	void updatePassword(String token, String newPassword) throws ResetPasswordException, ResetPasswordTokenException;
}
