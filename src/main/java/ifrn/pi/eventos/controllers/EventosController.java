package ifrn.pi.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.eventos.models.Evento;
import ifrn.pi.eventos.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventosController {
	
	@Autowired
	private EventoRepository er;
	
	@GetMapping("/form")
	public String form() {
		return "eventos/formEvento";
	}
	
	@RequestMapping
	public String nome(String nome){
		System.out.println("Nome do evento: " + nome);
		return "verificar";
	}
	@RequestMapping(path = "/eventos", method = RequestMethod.POST)
	public String adicionar(Evento evento) {
		System.out.println(evento);
		er.save(evento);
		return "eventos/evento-adicionado";
	}
	@GetMapping("/eventos")
	public ModelAndView listar() {
			List<Evento> eventos = er.findAll();
			ModelAndView mv = new ModelAndView("eventos/lista");
			mv.addObject("eventos", eventos);
			return mv;
		
	}
}
