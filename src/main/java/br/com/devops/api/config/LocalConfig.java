package br.com.devops.api.config;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.domain.Plano;
import br.com.devops.api.repositories.AlunoRepository;
import br.com.devops.api.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoRepository planoRepository;
    @Bean
    public void startDB(){
        Aluno a1 = new Aluno(null, "Victor", "victor@mail.com", "123");
        Aluno a2 = new Aluno(null, "Thiago", "thiago@mail.com", "123");
        Aluno a3 = new Aluno(null, "Bruna", "bruna@mail.com", "123");
        Aluno a4 = new Aluno(null, "Luiz", "luiz@mail.com", "123");
        Aluno a5 = new Aluno(null, "Carlos", "carlos@mail.com", "123");

        Plano gratuito = new Plano(null, "gratuito", 0, 3, "Gold, Diamond");
        Plano gold = new Plano(null, "gold", 50, 10, "Diamond");
        Plano diamond = new Plano(null, "diamond", 100, 999, null);

        alunoRepository.saveAll(List.of(a1, a2, a3, a4, a5));
        planoRepository.saveAll(List.of(gratuito, gold, diamond));
    }

}
