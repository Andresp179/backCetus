package com.example.demo.Repository;

import java.util.List;

import com.example.demo.Models.Producto;

public interface ProductoRepository {
	
	public interface ProductRepository {
	    void saveAll(List<Producto> products);
	}

}
