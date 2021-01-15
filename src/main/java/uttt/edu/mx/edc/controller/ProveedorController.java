package uttt.edu.mx.edc.controller;

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
import uttt.edu.mx.edc.model.Proveedor;
import uttt.edu.mx.edc.repository.ProveedorRepository;

@Controller
public class ProveedorController {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@RequestMapping(value = "/listarProveedores", method = RequestMethod.GET)
	public String AbreProveedor(Model model) {
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "listarProveedores";
	}
	
	@RequestMapping(value = "/registrarProveedor", method = RequestMethod.GET)
	public String AgregarProveedorV(Model model) {
		Proveedor proveedor=new Proveedor();
		model.addAttribute("proveedor",proveedor);
		return "registrarProveedor";
	}
	@RequestMapping(value = "/registrarProveedor", method = RequestMethod.POST)
	public String guardarProveedor(@Valid @ModelAttribute("proveedor") Proveedor registerProveedor, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) 
	{
		if(result.hasErrors()) {
			return "registrarProveedor";
		}
		proveedorRepository.save(registerProveedor);
		redirectAttrs
        .addFlashAttribute("mensaje", "Producto Agregado Correctamente")
        .addFlashAttribute("clase", "success");
		return "redirect:listarProveedores";
	}
	@RequestMapping(value = "/editarProveedor/{id}")
	public String EditarProveedor(@PathVariable(value="id") Long id, Model model) 
	{
		Proveedor proveedor = null;
		if(id >0) 
		{
		proveedor = proveedorRepository.getOne(id);	
		
		}
		else
		{
		return "redirect:listarProductos";
		}
		model.addAttribute("proveedor",proveedor);
		return "editarProveedor";
	}
	@RequestMapping(value = "/editarProveedor", method = RequestMethod.POST)
	public String EditarProveedor(@Valid @ModelAttribute("proveedor") Proveedor editarProveedor, Model model,
			RedirectAttributes redirectAttrs) 
	{
		
		//Editamos Producto en Almacen
		proveedorRepository.save(editarProveedor);
		redirectAttrs
        .addFlashAttribute("mensaje", "Proveedor Editado Correctamente")
        .addFlashAttribute("clase", "success");
		return "redirect:listarProveedores";
	}
	@RequestMapping(value = "/redirectProveedor", method = RequestMethod.POST)
	public String redirectProveedor() 
	{
		return "redirect:registrarProveedor";
	}
	
}
