package com.example.board.Service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    //@Override
   /* public class onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String msg="Invalid Email or Password";

        if(exception instanceof DisabledException){
            msg="DisabledExcepltion account";
        }
        else if(exception instanceof CredentialsExpiredException) {
            msg="CredentialExpiredException account";
        }
        else if(exception instanceof BadCredentialsException){
            msg="BadCredentialsException account";
        }
        setDefaultFailureUrl("/login?error=true&exception"+msg);

        super.onAuthenticationFailure(request, response, exception);
    }*/
}