package br.com.devops.api.services.impl;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.repositories.AlunoRepository;
import br.com.devops.api.services.AlunoService;
import br.com.devops.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno findById(Integer id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado :("));
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
}
