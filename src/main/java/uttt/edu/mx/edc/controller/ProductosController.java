package uttt.edu.mx.edc.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uttt.edu.mx.edc.model.BitacoraEntradaSalida;
import uttt.edu.mx.edc.model.Producto;
import uttt.edu.mx.edc.repository.BitacoraEntradaSalidasRepository;
import uttt.edu.mx.edc.repository.ProductoRepository;
import uttt.edu.mx.edc.repository.ProveedorRepository;

@Controller
public class ProductosController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	private BitacoraEntradaSalidasRepository bitacoraRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listarProductos(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "listarProductos";
	}
	
	@RequestMapping(value = "/listarProductos", method = RequestMethod.GET)
	public String listarProductoMetodoDos(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "listarProductos";
	}
	@RequestMapping(value = "/registrarProducto", method = RequestMethod.GET)
	public String RegistrarProducto(Model model) {
		Producto producto=new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "registrarProducto";
	}
	@RequestMapping(value = "/registrarProducto", method = RequestMethod.POST)
	public String guardarProducto(@Valid @ModelAttribute("producto") Producto registerProducto, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) 
	{
		if(result.hasErrors()) {
			model.addAttribute("proveedores", proveedorRepository.findAll());
			return "registrarProducto";
		}
		//Obtenemos Fecha y Hora
		Date date = new Date();
		//Guardamos en Bitacora
		BitacoraEntradaSalida bitacora=new BitacoraEntradaSalida();
		bitacora.setStrFechaHora(date);
		bitacora.setStrCantidad(registerProducto.getStrStock());
		bitacora.setStrDescripcion(registerProducto.getStrDescripcion());
		bitacora.setStrStatus("Entrada");
		bitacoraRepository.save(bitacora);
		//Registramos Producto en Almacen
		productoRepository.save(registerProducto);
		redirectAttrs
        .addFlashAttribute("mensaje", "Producto registrado Correctamente")
        .addFlashAttribute("clase", "success");
		return "redirect:listarProductos";
	}
	@RequestMapping(value = "/editarProducto/{id}")
	public String EditarProducto(@PathVariable(value="id") Long id, Model model) 
	{
		Producto producto = null;
		if(id >0) 
		{
		producto = productoRepository.getOne(id);	
		
		}
		else
		{
		return "redirect:listarProductos";
		}
		model.addAttribute("proveedores", proveedorRepository.findAll());
		model.addAttribute("producto",producto);
		return "editarProducto";
	}
	@RequestMapping(value = "/editarProducto", method = RequestMethod.POST)
	public String EditarProducto(@Valid @ModelAttribute("producto") Producto editarProducto, Model model,
			RedirectAttributes redirectAttrs) 
	{
		
		//Editamos Producto en Almacen
		productoRepository.save(editarProducto);
		redirectAttrs
        .addFlashAttribute("mensaje", "Producto Editado Correctamente")
        .addFlashAttribute("clase", "success");
		return "redirect:listarProductos";
	}
	@RequestMapping(value = "/redirectProducto", method = RequestMethod.POST)
	public String redirectProducto() 
	{
		return "redirect:registrarProducto";
	}
	
	
}
