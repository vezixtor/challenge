package com.herokuapp.infopricechallenge.repository;

import com.herokuapp.infopricechallenge.model.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}