package br.com.devops.api.services;

import br.com.devops.api.domain.Plano;
import br.com.devops.api.domain.dto.PlanoDTO;

import java.util.List;

public interface PlanoService {
    Plano findById(Integer id );
    List<Plano> findAll();
    Plano create(PlanoDTO obj);
    Plano update(PlanoDTO obj);
    void delete(Integer id);
}
