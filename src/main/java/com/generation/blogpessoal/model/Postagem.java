package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity           //indica para o spring tratar nossa classe como uma entidade/tabela
@Table(name = "tb_postagens")      // indica o nome da tabela que sera criada no banco de dados            
public class Postagem {
	
	@Id        //indentifica a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
	private Long id;
	
	@NotBlank(message = "Esse campo é obrigatório")   //Not Null
	@Size(min = 5, max = 100, message = "Digite no min 5 e no maximo 10 caracteres")
	private String titulo;

	@NotBlank(message = "Esse campo é obrigatório")   //Not Null
	@Size(min = 10, max = 1000, message = "Digite no min 5 e no maximo 10 caracteres")
	private String texto;
	
	@UpdateTimestamp // marca a data da criação
	private LocalDateTime data; // 10/10/25 18:25:58
	
	private String github;

	private String imagem;
	
	private String linkedin;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
