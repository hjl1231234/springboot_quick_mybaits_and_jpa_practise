package com.firstapp.repository;

import com.firstapp.domain.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJPARepository extends JpaRepository<UserJPA, Long> {
    @Override
    public List<UserJPA> findAll();

}
