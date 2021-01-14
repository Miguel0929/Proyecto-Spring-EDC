package uttt.edu.mx.edc.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uttt.edu.mx.edc.model.Pedido;
import uttt.edu.mx.edc.repository.PedidoRepository;

@Controller
public class PedidosController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@RequestMapping(value = "/listarPedidos", method = RequestMethod.GET)
	public String listarpedidos(Model model) {
		model.addAttribute("pedidos", pedidoRepository.findAll());
		return "listarPedidos";
	}
	@RequestMapping(value = "/registrarPedido", method = RequestMethod.GET)
	public String AgregarNuevoPedido(Model model) {
		Pedido pedido=new Pedido();
		model.addAttribute("pedido",pedido);
		return "registrarPedido";
	}
	@RequestMapping(value = "/registrarPedido", method = RequestMethod.POST)
	public String guardarPedido(@Valid @ModelAttribute("pedido") Pedido registerPedido, BindingResult result, Model model) 
	{
		if(result.hasErrors()) {
			return "registrarPedido";
		}
		pedidoRepository.save(registerPedido);
		return "redirect:listarPedidos";
	}
		
}
