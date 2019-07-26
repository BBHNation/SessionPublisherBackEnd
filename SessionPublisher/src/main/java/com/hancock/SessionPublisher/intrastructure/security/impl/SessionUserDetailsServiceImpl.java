package com.hancock.SessionPublisher.intrastructure.security.impl;

import com.hancock.SessionPublisher.intrastructure.security.SessionUserDetailsService;
import com.hancock.SessionPublisher.intrastructure.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SessionUserDetailsServiceImpl implements SessionUserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public SessionUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
