package com.aniket.E_Com_Back_End.service;

import com.aniket.E_Com_Back_End.model.User;
import com.aniket.E_Com_Back_End.model.UserPrincipal;
import com.aniket.E_Com_Back_End.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email);
        if(user == null){
            System.out.println("User 404 : User not found !");
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }
}
