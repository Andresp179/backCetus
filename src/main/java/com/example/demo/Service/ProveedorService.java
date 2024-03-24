package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Proveedor;


public interface ProveedorService {
	
	public List<Proveedor> listaProveedores();

    public void guardar (Proveedor proveedor);

    public void eliminar (Proveedor proveedor);

    public Optional<Proveedor> encontrarProveedor(Proveedor proveedor);

	

}
