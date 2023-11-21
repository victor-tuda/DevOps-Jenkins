package br.com.devops.api.services.impl;

import br.com.devops.api.domain.Plano;
import br.com.devops.api.domain.dto.PlanoDTO;
import br.com.devops.api.repositories.PlanoRepository;
import br.com.devops.api.services.PlanoService;
import br.com.devops.api.services.exceptions.DataIntegratyViolationException;
import br.com.devops.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoServiceImpl implements PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Plano findById(Integer id) {
        Optional<Plano> obj = planoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Plano não encontrado :("));
    }

    public List<Plano> findAll() {
        return planoRepository.findAll();
    }

    @Override
    public Plano create(PlanoDTO obj) {
        return planoRepository.save(mapper.map(obj, Plano.class));
    }

    @Override
    public Plano update(PlanoDTO obj) {
        return planoRepository.save(mapper.map(obj, Plano.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        planoRepository.deleteById(id);
    }

}
