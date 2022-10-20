package ifrn.pi.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ifrn.pi.eventos.models.Evento;
import ifrn.pi.eventos.repositories.EventoRepository;

@Controller
public class EventosController {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping("/eventos/form")
	public String form() {
		return "eventos/formEvento";
	}
	
	@RequestMapping("/Eventos")
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
}
