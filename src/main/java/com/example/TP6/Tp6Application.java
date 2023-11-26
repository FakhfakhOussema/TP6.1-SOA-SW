package com.example.TP6;

import entities.Compte;
import entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CompteRepository;

import java.util.Date;
@EnableJpaRepositories(basePackages={"repositories"})
@SpringBootApplication
public class Tp6Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp6Application.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository)
	{
		return args ->
		{
			compteRepository.save(new Compte(null,30,new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null,70,new Date(), TypeCompte.COURANT));
			compteRepository.findAll().forEach(c->{
				System.out.println(c);
			});
		};

	}

}


