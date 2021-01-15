package uttt.edu.mx.edc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String guardarProveedor(@Valid @ModelAttribute("proveedor") Proveedor registerProveedor, BindingResult result, Model model) 
	{
		if(result.hasErrors()) {
			return "registrarProveedor";
		}
		proveedorRepository.save(registerProveedor);
		return "redirect:listarProveedores";
	}
}
