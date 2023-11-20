package br.com.devops.api.services.impl;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.domain.dto.AlunoDTO;
import br.com.devops.api.repositories.AlunoRepository;
import br.com.devops.api.services.AlunoService;
import br.com.devops.api.services.exceptions.DataIntegratyViolationException;
import br.com.devops.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Aluno findById(Integer id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado :("));
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno create(AlunoDTO obj) {
        findByEmail(obj);
        return alunoRepository.save(mapper.map(obj, Aluno.class));
    }

    @Override
    public Aluno update(AlunoDTO obj) {
        findByEmail(obj);
        return alunoRepository.save(mapper.map(obj, Aluno.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        alunoRepository.deleteById(id);
    }

    private void findByEmail(AlunoDTO obj) {
        Optional<Aluno> aluno = alunoRepository.findByEmail(obj.getEmail());
        if (aluno.isPresent()) {
            throw new DataIntegratyViolationException("E-mail já cadastado no sistema");
        }
    }
}
