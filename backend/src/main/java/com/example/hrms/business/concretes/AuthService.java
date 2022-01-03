package com.example.hrms.business.concretes;

import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.dataAccess.abstracts.UserRoleDao;
import com.example.hrms.entities.abstracts.User;
import com.example.hrms.entities.abstracts.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserDao userRepository;
    private final UserRoleDao userRoleRepository;

    public Result addRoleToUser(String email,String roleName){
        try{
            UserRole role = userRoleRepository.getUserRoleByRole(roleName);
            User user = userRepository.findUserByEmail(email);
            user.getRoles().add(role);
            userRepository.save(user);
    }catch (Exception e){
            return new ErrorResult();
        }
        return new SuccessResult();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = this.userRepository.findUserByEmail(s);
        if(user==null){
            throw new UsernameNotFoundException("User not found");

        }

        Collection<GrantedAuthority> auths = new ArrayList<>();

        user.getRoles().forEach(role->{
                    auths.add(new SimpleGrantedAuthority(role.getRole()));
                }
                );
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),auths);
    }
}