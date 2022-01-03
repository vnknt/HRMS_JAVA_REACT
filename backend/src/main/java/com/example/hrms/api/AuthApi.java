package com.example.hrms.api;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.abstracts.User;
import com.example.hrms.security.TokenManager;
import com.example.hrms.security.model.AuthRequest;
import com.example.hrms.security.model.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin()
public class AuthApi {

    private final TokenManager tokenManager;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserDao userDao;

    @PostMapping
    public ResponseEntity<DataResult<AuthResponse>> login(@RequestBody AuthRequest authRequest){

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword())
            );

        }catch (BadCredentialsException exception){
            throw exception;
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        User user = userDao.findUserByEmail(authRequest.getEmail());
        return ResponseEntity.ok(
                new SuccessDataResult<>(new AuthResponse(
                        tokenManager.generateToken(userDetails,user.getUserId())
                ))

        );
    }


}
