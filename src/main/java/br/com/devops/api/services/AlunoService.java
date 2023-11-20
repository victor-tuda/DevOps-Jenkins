package br.com.devops.api.services;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.domain.dto.AlunoDTO;

import java.util.List;

public interface AlunoService {
    Aluno findById(Integer id );
    List<Aluno> findAll();
    Aluno create(AlunoDTO obj);

}
