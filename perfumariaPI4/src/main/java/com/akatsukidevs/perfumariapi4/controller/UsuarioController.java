package com.akatsukidevs.perfumariapi4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akatsukidevs.perfumariapi4.model.Usuario;
import com.akatsukidevs.perfumariapi4.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository ur;
	
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)
	public String formulario() {
		return("acesso/cadastrarUsuario");
	}
	
	//para cadastro do usuario solicitando o post
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public String formulario(Usuario usuario) {
		ur.save(usuario);
		return("redirect:/cadastrarUsuario");
	}
	
	@RequestMapping("/usuarios")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("/acesso/usuario");
		Iterable<Usuario> usuarios = ur.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
		
	}
	
	
	
}
