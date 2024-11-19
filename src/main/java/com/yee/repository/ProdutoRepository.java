package com.yee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yee.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
