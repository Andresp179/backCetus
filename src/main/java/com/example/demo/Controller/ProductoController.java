package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Producto;
import com.example.demo.Repository.ProductoDao;
import com.example.demo.Excepciones.ResourceNotFoundException;







@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductoController {

	@Autowired
	private ProductoDao productoServiceImpl;

	@RequestMapping(value = "/api/v1/productos", method = RequestMethod.GET)
	public List<Producto> listarProductos() {
		return productoServiceImpl.findAll();
	}

	// este metodo sirve para guardar el PRODUCTO
	@PostMapping("/api/v1/productos")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.save(producto);
	}

	// este metodo sirve para buscar un producto
	@GetMapping("/api/v1/productos/{id}")
	public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
		Producto producto = productoServiceImpl.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
		return ResponseEntity.ok(producto);
	}
	
	//este metodo sirve para actualizar producto
		@PutMapping("/api/v1/productos/{id}")
		public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id,@RequestBody Producto detallesProducto){
			Producto producto = productoServiceImpl.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
			
			producto.setNombreProducto(detallesProducto.getNombreProducto());
			producto.setDescripcion(detallesProducto.getDescripcion());
			producto.setEstado(detallesProducto.getEstado());
			producto.setNombreLaboratorio(detallesProducto.getNombreLaboratorio());
			
			Producto productoActualizado = productoServiceImpl.save(producto);
			return ResponseEntity.ok(productoActualizado);
	    }
		
		@DeleteMapping("/api/v1//productos/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable Long id){
			Producto producto = productoServiceImpl.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
			
			productoServiceImpl.delete(producto);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
