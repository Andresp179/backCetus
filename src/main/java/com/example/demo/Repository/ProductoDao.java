package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

}
