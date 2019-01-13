package com.herokuapp.infopricechallenge.repository;

import com.herokuapp.infopricechallenge.model.entity.Cidade;
import com.herokuapp.infopricechallenge.model.type.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Page<Cidade> findByEstado(Estado estado, Pageable pageable);
}