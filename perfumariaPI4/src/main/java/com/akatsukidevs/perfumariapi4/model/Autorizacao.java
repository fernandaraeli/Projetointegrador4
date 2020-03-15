package com.akatsukidevs.perfumariapi4.model;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Autorizacao implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		
		return null;
	}

}
