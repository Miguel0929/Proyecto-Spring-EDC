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
import uttt.edu.mx.edc.model.DetallePedido;
import uttt.edu.mx.edc.model.Pedido;
import uttt.edu.mx.edc.model.Producto;
import uttt.edu.mx.edc.repository.BitacoraEntradaSalidasRepository;
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
	
	@Autowired
	private BitacoraEntradaSalidasRepository bitacoraRepository;
	
	
	
	@RequestMapping(value = "/detallePedido/{id}")
	public String AbrirDetalle(@PathVariable(value="id") Long id, Model model) 
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
		//Carga todos los productos que ha comprado
		model.addAttribute("compras",detalleRepository.findAllDetalle(id));
		//Carga el select de los productos
		model.addAttribute("productos",productoRepository.findAll());
		return "detallePedido";
	}
	@RequestMapping(value = "/detallePedido", method = RequestMethod.POST)
	public String guardarDetalle(@Valid @ModelAttribute("detallePedido") DetallePedido registerDetalle, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) 
	{
		//Obtenemos Fecha y Hora
		Date date = new Date();
		//Buscamos el Producto
		int strCantidad=registerDetalle.getStrCantidad();
		Long idProducto= registerDetalle.getProducto().getId();
		Producto producto= productoRepository.getOne(idProducto);
		if(registerDetalle.getStrCantidad()>producto.getStrStock() || registerDetalle.getStrCantidad()==0 || registerDetalle.getStrCantidad()<0) {
			redirectAttrs
            .addFlashAttribute("mensaje", "No es posible Completar, Por que no hay Stock Disponible")
            .addFlashAttribute("clase", "danger");
			return "redirect:listarPedidos";
		}else {
			//Guardar en Bitacora
			BitacoraEntradaSalida bitacora=new BitacoraEntradaSalida();
			bitacora.setStrFechaHora(date);
			bitacora.setStrCantidad(registerDetalle.getStrCantidad());
			bitacora.setStrDescripcion(registerDetalle.getProducto().getStrDescripcion());
			bitacora.setStrStatus("Salida");
			bitacoraRepository.save(bitacora);
		    //Guardamos la compra
			
			detalleRepository.save(registerDetalle);
			//Restamos Stock y Guardamos Producto
			producto.setStrStock(producto.getStrStock()-strCantidad);
		    productoRepository.save(producto);
		    redirectAttrs
            .addFlashAttribute("mensaje", "Su compra fue registrada, Correctamente")
            .addFlashAttribute("clase", "success");
			return "redirect:listarPedidos";
		}
		
	}
	
}
