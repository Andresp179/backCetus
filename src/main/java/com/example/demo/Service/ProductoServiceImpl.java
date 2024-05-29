package com.example.demo.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.Models.Producto;
import com.example.demo.Models.Proveedor;
import com.example.demo.Repository.ProductoDao;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDao productoDao;
	private  JdbcTemplate jdbcTemplate;
	private Producto save;
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

	@Override
	public int[] batchUpdateUsingJdbcTemplate(List<Producto> productos) {
	
	return jdbcTemplate.batchUpdate("INSERT INTO producto VALUES (?, ?, ?, ?,?)", (BatchPreparedStatementSetter) new BatchPreparedStatementSetter() {

	            @Override
	            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
	                ps.setLong(1, productos.get(i).getIdProducto());
	                ps.setString(2, productos.get(i).getNombreProducto());
	                ps.setString(3, productos.get(i).getDescripcion());
	                ps.setString(4, productos.get(i).getEstado());
	                ps.setString(5, productos.get(i).getNombreLaboratorio());
	            }

	            @Override
	            public int getBatchSize() {
	                return 3;
	            }				
	        });
	}

}
