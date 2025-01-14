package com.generation.blogpessoal.controller;

// Importação de bibliotecas necessárias
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
import com.generation.blogpessoal.repository.TemaRepository;

import jakarta.validation.Valid;

// Indica que esta classe é um controlador REST, que lida com requisições HTTP
@RestController
// Define o endpoint base para todas as rotas deste controlador
@RequestMapping("/postagens")
// Permite requisições de qualquer origem (CORS) e qualquer cabeçalho
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
    
    // Injeta automaticamente uma instância do repositório
    @Autowired
    private PostagemRepository postagemRepository;
    
    @Autowired
    private TemaRepository temaRepository;

    // Mapeia requisições GET para "/postagens", retornando todas as postagens
    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        // Retorna a lista de postagens com status HTTP 200 (OK)
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    // Mapeia requisições GET para "/postagens/{id}", retornando uma postagem específica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable Long id) {
        // Busca a postagem pelo ID. Se não encontrar, retorna status 404 (Not Found)
        return postagemRepository
                .findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Mapeia requisições GET para "/postagens/titulo/{titulo}", retornando postagens que contêm o título informado
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
        // Busca todas as postagens cujo título contém o texto fornecido, ignorando maiúsculas/minúsculas
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    // Mapeia requisições POST para "/postagens", criando uma nova postagem
    @PostMapping
    public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem) {
        if(temaRepository.existsById(postagem.getTema().getId())) {
    	// Salva a postagem no banco e retorna status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postagemRepository.save(postagem));
        }
        
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tema não existe!",null);
    }

    // Mapeia requisições PUT para "/postagens", atualizando uma postagem existente
    @PutMapping
    public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
    	if(postagemRepository.existsById(postagem.getId())){
    		if(temaRepository.existsById(postagem.getTema().getId())) {
    			return ResponseEntity.status(HttpStatus.OK)
    					.body(postagemRepository.save(postagem));
    		
    		}
    			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tema não existe!",null);
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Mapeia requisições DELETE para "/postagens/{id}", removendo uma postagem pelo ID
    @ResponseStatus(HttpStatus.NO_CONTENT) // Define o status de sucesso como 204 (No Content)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // Verifica se a postagem com o ID fornecido existe
        Optional<Postagem> postagem = postagemRepository.findById(id);
        
        // Se não encontrar, lança uma exceção com status 404 (Not Found)
        if (postagem.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Remove a postagem do banco
        postagemRepository.deleteById(id);
    }
}
