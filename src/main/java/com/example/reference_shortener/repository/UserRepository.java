package com.example.reference_shortener.repository;

import com.example.reference_shortener.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Класс UserRepository
 */
public interface UserRepository extends JpaRepository<AUser, Integer> {

	Optional<AUser> findByName(String  name);
}