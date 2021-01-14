package uttt.edu.mx.edc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uttt.edu.mx.edc.repository.BitacoraEntradaSalidasRepository;

@Controller
public class BitacoraEntradaSalidaController {

	@Autowired
	private BitacoraEntradaSalidasRepository bitacoras;
	
	@RequestMapping(value = "/listarBitacora", method = RequestMethod.GET)
	public String listarBitacora (Model model) {
		model.addAttribute("bitacoras", bitacoras.findAll());
		return "listarBitacora";
	}
}
