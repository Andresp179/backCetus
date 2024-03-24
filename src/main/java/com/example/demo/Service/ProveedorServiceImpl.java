package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Proveedor;
import com.example.demo.Repository.ProveedorDao;



public class ProveedorServiceImpl implements ProveedorService {

	private ProveedorDao proveedorDao;
	
	@Override
	public List<Proveedor> listaProveedores() {
		// TODO Auto-generated method stub
		return (List<Proveedor>) proveedorDao.findAll();
	}

	@Override
	public void guardar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		proveedorDao.save(proveedor);
	}

	@Override
	public void eliminar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		proveedorDao.delete(proveedor);
	}

	@Override
	public Optional<Proveedor> encontrarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorDao.findById(proveedor.getIdProveedor());
	}

}
