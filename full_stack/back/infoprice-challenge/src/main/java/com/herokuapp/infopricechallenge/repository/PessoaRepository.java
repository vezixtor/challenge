package com.herokuapp.infopricechallenge.repository;

import com.herokuapp.infopricechallenge.model.entity.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
}