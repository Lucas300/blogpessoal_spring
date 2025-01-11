package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;


@RestController         //aqui falamos que a classe é do tipo RestController e recebera as requisições
@RequestMapping("/postagens") //cria o caminho da URL para  http:8080/postagens
@CrossOrigin(origins = "*",allowedHeaders = "*")  // aqui falamos que a classe podera receber uma requisição externa da aplicação
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;

	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
}
