package br.com.devops.api.resources;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.domain.dto.AlunoDTO;
import br.com.devops.api.services.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
