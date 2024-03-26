package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.Producto;
import com.example.demo.Repository.ProductoDao;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDao productoDao;

	@Override
	public List<Producto> listaProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		productoDao.save(producto);
	}

	@Override
	public void eliminar(Producto producto) {
		// TODO Auto-generated method stub
		productoDao.delete(producto);
	}

	@Override
	public Optional<Producto> encontrarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoDao.findById(producto.getIdProducto());
	}

}
