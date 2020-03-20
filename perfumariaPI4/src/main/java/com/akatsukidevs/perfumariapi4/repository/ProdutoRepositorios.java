package com.akatsukidevs.perfumariapi4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akatsukidevs.perfumariapi4.model.Produtos;

public interface ProdutoRepositorios extends JpaRepository<Produtos, Long>{

}
