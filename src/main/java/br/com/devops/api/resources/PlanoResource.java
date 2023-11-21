package br.com.devops.api.resources;

import br.com.devops.api.domain.Plano;
import br.com.devops.api.domain.dto.PlanoDTO;
import br.com.devops.api.services.PlanoService;
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
@RequestMapping(value = "/plano")
public class PlanoResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlanoService planoService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<PlanoDTO> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(mapper.map(planoService.findById(id), PlanoDTO.class));

    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> findAll() {
        List<Plano> list = planoService.findAll();
        List<PlanoDTO> listDTO = list.stream().map(x -> mapper.map(x, PlanoDTO.class)).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<List<PlanoDTO>> create(@RequestBody PlanoDTO obj) {
        Plano newObj = planoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PlanoDTO> update(@PathVariable Integer id, @RequestBody PlanoDTO obj) {
        obj.setId(id);
        Plano newPlano = planoService.update(obj);
        return ResponseEntity.ok().body(mapper.map(newPlano, PlanoDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PlanoDTO> delete(@PathVariable Integer id) {
        planoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
