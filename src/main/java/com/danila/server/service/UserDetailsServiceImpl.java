package com.danila.server.service;

import com.danila.server.model.UserDetails;
import com.danila.server.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public List<UserDetails> getAll() {
        return (List<UserDetails>) userDetailsRepository.findAll();
    }

    @Override
    public UserDetails findById(Long id) {
        return userDetailsRepository.findById(id).orElseThrow();
    }

    @Override
    public UserDetails insert(@RequestBody UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails update(Long id, @RequestBody UserDetails newUserDetails) {
        UserDetails userDetails = userDetailsRepository.findById(id).orElseThrow();

        userDetails.setUsername(newUserDetails.getUsername());
        userDetails.setEmail(newUserDetails.getEmail());

        return userDetailsRepository.save(userDetails);
    }

    @Override
    public String delete(Long id) {
        UserDetails userDetails = userDetailsRepository.findById(id).orElseThrow();
        String deletedUserDetailsInfo = userDetails.toString();

        userDetailsRepository.delete(userDetails);
        return "Deleted: " + deletedUserDetailsInfo;
    }
}
