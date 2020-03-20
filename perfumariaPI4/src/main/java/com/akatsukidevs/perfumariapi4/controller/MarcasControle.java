package com.akatsukidevs.perfumariapi4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarcasControle {
	
	@GetMapping("/cadastrarMarcas")
	public String cadastrar() {
		return ("admin/marcas/cadastro");
	}
	
	@GetMapping("/listarMarcas")
	public String listar() {
		return ("admin/marcas/lista");
	}

}
