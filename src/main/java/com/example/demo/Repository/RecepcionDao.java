package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Recepcion;

public interface RecepcionDao extends JpaRepository<Recepcion, Long> {

}
