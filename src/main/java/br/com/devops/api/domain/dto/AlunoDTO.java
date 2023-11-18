package br.com.devops.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    private Integer id;
    private String nome;
    private String email;
    private String password;
}
