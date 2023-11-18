package br.com.devops.api.services.impl;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.repositories.AlunoRepository;
import br.com.devops.api.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno findById(Integer id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElse(null);
    }
}
