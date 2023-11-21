package br.com.devops.api.repositories;

import br.com.devops.api.domain.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Integer> {
}
