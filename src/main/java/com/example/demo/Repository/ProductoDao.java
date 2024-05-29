package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Models.Producto;
import com.example.demo.Models.Proveedor;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

}

