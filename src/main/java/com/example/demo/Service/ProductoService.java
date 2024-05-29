package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Producto;

public interface ProductoService {

	public List<Producto> listaProductos();

    public void guardar (Producto producto);

    public void eliminar (Producto producto);

    public Optional<Producto> encontrarProducto(Producto producto);	
    
    public int[] batchUpdateUsingJdbcTemplate(List<Producto> productos);    
    
	
}
