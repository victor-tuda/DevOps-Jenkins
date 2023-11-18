package br.com.devops.api.resources;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

    private AlunoService alunoService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(alunoService.findById(id));

    }
}
