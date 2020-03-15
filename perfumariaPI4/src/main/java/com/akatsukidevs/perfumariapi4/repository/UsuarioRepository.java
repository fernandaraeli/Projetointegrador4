package com.akatsukidevs.perfumariapi4.repository;

import org.springframework.data.repository.CrudRepository;

import com.akatsukidevs.perfumariapi4.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByEmail(String email);
	
}
