package com.example.pract2.repository;

import com.example.pract2.model.ModelUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ModelUser, Long> {
    ModelUser findByUsername(String username);
    boolean existsByUsername(String username);
}
