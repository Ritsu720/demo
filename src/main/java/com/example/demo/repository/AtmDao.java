package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Atm;

@Repository
public interface AtmDao extends JpaRepository<Atm, String>{

}
