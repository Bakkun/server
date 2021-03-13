package com.danila.server.repository;

import com.danila.server.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
}
