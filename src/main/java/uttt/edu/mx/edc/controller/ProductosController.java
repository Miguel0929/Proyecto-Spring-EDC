package uttt.edu.mx.edc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uttt.edu.mx.edc.model.Producto;
import uttt.edu.mx.edc.repository.ProductoRepository;
import uttt.edu.mx.edc.repository.ProveedorRepository;

@Controller
public class ProductosController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listarProductos(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "almacenProductos";
	}
	
	@RequestMapping(value = "/almacenProductos", method = RequestMethod.GET)
	public String listarProductoMetodoDos(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "almacenProductos";
	}
	@RequestMapping(value = "/registrarProducto", method = RequestMethod.GET)
	public String RegistrarProducto(Model model) {
		Producto producto=new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "registrarProducto";
	}
	@RequestMapping(value = "/registrarProducto", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("producto") Producto registerProducto, BindingResult result, Model model) 
	{
		if(result.hasErrors()) {
			model.addAttribute("proveedores", proveedorRepository.findAll());
			return "registrarProducto";
		}
		productoRepository.save(registerProducto);
		return "redirect:almacenProductos";
	}
}
