package com.example.demo.Controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.Models.Producto;
import com.example.demo.Repository.ProductoDao;


@Controller
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200/")
public class ProductoController {

	@Autowired
	private ProductoDao productoServiceImpl;

		
	@RequestMapping(value = "/api/v1/productos", method = RequestMethod.GET)
	public List<Producto> listarProductos(Model model) {
		return productoServiceImpl.findAll();
	}
	
}
