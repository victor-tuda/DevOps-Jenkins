package br.com.devops.api;

import br.com.devops.api.domain.Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		Aluno aluno = new Aluno(1, "Victor", "victor.gtuda@gmail.com", "123");

		System.out.println(aluno);
	}

}
