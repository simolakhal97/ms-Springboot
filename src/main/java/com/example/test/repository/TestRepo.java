package com.example.test.repository;

import com.example.test.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface TestRepo extends JpaRepository<Test,Long> {
    Optional<Test> findByEmail(String email);

    Page<Test> findAll(Specification<Test> spec, Pageable pageable);
}
