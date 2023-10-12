package com.hcc.repositories;

import com.hcc.endpoints.models.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {

    Optional<UserTable> findByUsername(String username);
}