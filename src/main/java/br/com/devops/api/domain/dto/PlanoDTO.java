package br.com.devops.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoDTO {
    private Integer id;
    private String nome;
    private double valor;
    private Integer cursosLiberados;
    private String ofertaNovosPlanos;
}
