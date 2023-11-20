package br.com.devops.api.resources;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.domain.dto.AlunoDTO;
import br.com.devops.api.services.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AlunoService alunoService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(mapper.map(alunoService.findById(id), AlunoDTO.class));

    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> findAll() {
        List<Aluno> list = alunoService.findAll();
        List<AlunoDTO> listDTO = list.stream().map(x -> mapper.map(x, AlunoDTO.class)).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<List<AlunoDTO>> create(@RequestBody AlunoDTO obj) {
        Aluno newObj = alunoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Integer id, @RequestBody AlunoDTO obj) {
        obj.setId(id);
        Aluno newAluno = alunoService.update(obj);
        return ResponseEntity.ok().body(mapper.map(newAluno, AlunoDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> delete(@PathVariable Integer id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
