package com.herokuapp.infopricechallenge.model.entity;

import com.herokuapp.infopricechallenge.model.type.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public void put(Cidade entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.nome = entity.getNome();
            this.estado = entity.getEstado();
        }
    }
}
