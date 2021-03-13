package com.danila.server.service;

import com.danila.server.model.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserDetailsService {
    @Transactional(readOnly = true)
    List<UserDetails> getAll();

    @Transactional(readOnly = true)
    UserDetails findById(Long id);

    @Transactional
    UserDetails insert(UserDetails userDetails);

    @Transactional
    UserDetails update(Long id, UserDetails userDetails);

    @Transactional
    String delete(Long id);
}
