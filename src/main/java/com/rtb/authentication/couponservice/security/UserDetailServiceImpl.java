package com.rtb.authentication.couponservice.security;

import com.rtb.authentication.couponservice.model.User;
import com.rtb.authentication.couponservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    // this method receives the username passed by the client, and we can use it to define our custom implementation
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null){

            throw new UsernameNotFoundException("User not found for the email : " + username);
        }

        // converting our user model to UserDetail model provided by the spring security
        // here we are passing user.getRoles() as authorities, that's why we implemented GrantedAuthority in Role model
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
    }
}
