package com.marcuschiu.securityuserdetailsservice.service;

import com.marcuschiu.securityuserdetailsservice.model.Authorities;
import com.marcuschiu.securityuserdetailsservice.model.Users;
import com.marcuschiu.securityuserdetailsservice.repo.AuthoritiesRepository;
import com.marcuschiu.securityuserdetailsservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    // WITHOUT CUSTOM PRINCIPAL WRAPPER
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user != null) {
            List<Authorities> authorities = authoritiesRepository.findAllByUsername(username);
            String[] roles = authorities.stream().map(Authorities::getAuthority).toArray(String[]::new);
            return User.withUsername(username)
                    .password(user.getPassword())
                    .roles(roles).build();
        }
        throw new UsernameNotFoundException(username);
    }

    // WITH CUSTOM PRINCIPAL WRAPPER
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new MyUserPrincipal(user);
//    }
}
