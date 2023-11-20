package br.com.devops.api.services;

import br.com.devops.api.domain.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno findById(Integer id );
    List<Aluno> findAll();

}
