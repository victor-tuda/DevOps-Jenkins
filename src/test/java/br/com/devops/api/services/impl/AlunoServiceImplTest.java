package br.com.devops.api.services.impl;

import br.com.devops.api.domain.Aluno;
import br.com.devops.api.domain.dto.AlunoDTO;
import br.com.devops.api.repositories.AlunoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlunoServiceImplTest {
    private static final int ID = 1;
    private static final String NOME = "Victor";
    private static final String EMAIL = "victor@mail.com";
    private static final String PASSWORD = "123";

    @InjectMocks
    private AlunoServiceImpl alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @Mock
    private ModelMapper mapper;

    private Aluno aluno;
    private AlunoDTO alunoDTO;
    private Optional<Aluno> optionalAluno;

    private void startAluno(){
        aluno = new Aluno(ID, NOME, EMAIL, PASSWORD);
        alunoDTO = new AlunoDTO(ID, NOME, EMAIL, PASSWORD);
        optionalAluno = Optional.of(new Aluno(ID, NOME, EMAIL, PASSWORD));
    }
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAluno();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        Mockito.when(alunoRepository.findById(Mockito.anyInt())).thenReturn(optionalAluno);
        Aluno response = alunoService.findById(ID);

        assertNotNull(response);
        assertEquals(Aluno.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }


}