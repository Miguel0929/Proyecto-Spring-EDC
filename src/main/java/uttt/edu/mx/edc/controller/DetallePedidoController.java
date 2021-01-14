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

import uttt.edu.mx.edc.model.DetallePedido;
import uttt.edu.mx.edc.model.Pedido;
import uttt.edu.mx.edc.repository.DetallePedidoRepository;
import uttt.edu.mx.edc.repository.PedidoRepository;
import uttt.edu.mx.edc.repository.ProductoRepository;

@Controller
public class DetallePedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private DetallePedidoRepository detalleRepository;
	
	
	private Long ID_pedido=null;
	@RequestMapping(value = "/detallePedido/{id}")
	public String editarArticulos(@PathVariable(value="id") Long id, Model model) 
	{
		Pedido pedido = null;
		if(id >0) 
		{
		pedido = pedidoRepository.getOne(id);	
		
		}
		else
		{
		return "redirect:listarPedidios";
		}
		//Carga por primera vez la pantalla
		DetallePedido detallePedido=new DetallePedido();
		model.addAttribute("detallePedido",detallePedido);
		//Carga Informacion del Pedido
		model.addAttribute("pedido", pedido);
		ID_pedido=pedido.getId();
		//Carga todos los productos que ha comprado
		model.addAttribute("compras",detalleRepository.findAllDetalle(id));
		//Carga el select de los productos
		model.addAttribute("productos",productoRepository.findAll());
		return "detallePedido";
	}
	@RequestMapping(value = "/detallePedido", method = RequestMethod.POST)
	public String guardarDetalle(@Valid @ModelAttribute("detallePedido") DetallePedido registerDetalle, BindingResult result, Model model) 
	{
		registerDetalle.setId(ID_pedido);
		detalleRepository.save(registerDetalle);
		return "redirect:listarPedidos";
	}
	
}
