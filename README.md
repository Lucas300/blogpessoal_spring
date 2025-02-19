# Implementando um CRUD completo em Java com Spring Boot

Este projeto implementa um CRUD completo utilizando Java e Spring Boot, incluindo relacionamento entre entidades e configuração de segurança com Spring Security e JWT.

## Testando a aplicação

### A aplicação possui um deploy e está documentada no Swagger. Para acessá-la e testar seus endpoints, basta acessar o seguinte endereço: [Deploy da aplicação](https://blogpessoal-schf.onrender.com)

### Ou 

## Teste na sua máquina <a href="#testar">Instruções</a>

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- Hibernate
- PostgreSQL
- Maven
- Swagger

## 🛠 Principais pontos abordados no projeto

✔️ Estruturação de entidades no banco de dados com JPA e validações.<br>
✔️ Configuração de autenticação e autorização utilizando Spring Security e JWT.<br>
✔️ Desenvolvimento de endpoints RESTful com métodos HTTP (GET, POST, PUT, DELETE).<br>
✔️ Implementação de relacionamento OneToMany entre as entidades.<br>
✔️ Criação de um serviço de autenticação para proteger rotas e garantir acesso seguro aos recursos.<br><br>

Além disso, o projeto seguiu boas práticas, como o uso de injeção de dependências (@Autowired), DTOs para login e senha e validação de dados de entrada com Bean Validation.

🎯 Foi uma experiência incrível que me ajudou a consolidar o aprendizado e expandir meus conhecimentos no desenvolvimento de APIs seguras e eficientes.

## <div id="testar">Instruções para rodar na sua máquina</div>

1. Certifique-se de ter o Java 17+ instalado e o MySQL Workbench configurado.<br>
2. Baixe a aplicação no seu computador através do repositório: [GitHub](https://github.com/Lucas300/blogpessoal_spring.git) ou baixe o arquivo compactado e extraia-o para o local de sua preferência.<br>
3. Abra o projeto na sua IDE de preferência.<br>
4. Importe o projeto como "Existing Maven Projects".<br>

### Exemplo usando o Spring Tools/Eclipse:
<img width="500px" src="imagens_readme/import_maven_project.JPG"><br>

5. Aguarde até que a IDE baixe todas as dependências do projeto.<br>
6. Verifique se o perfil ativo da aplicação está definido como "dev":<br>
<img width="500px" src="imagens_readme/config_bd.JPG"><br>

7. No arquivo `application-dev.properties`, verifique e ajuste seu usuário e senha do MySQL, se necessário:<br>
<img width="500px" src="imagens_readme/banco_config.JPG"><br>

8. Execute a aplicação:<br>

### Exemplo usando o Spring Tools/Eclipse:
<img width="500px" src="imagens_readme/como_rodar.jpg"><br>

9. Acesse a aplicação através do navegador no endereço: [http://localhost:8080/](http://localhost:8080/)

### Agora você já pode explorar a API documentada com Swagger:
<img width="500px" src="imagens_readme/swagger.JPG"><br>

# 🛠 Front-end in progress... [https://github.com/Lucas300/portifolioReact.git](https://github.com/Lucas300/portifolioReact)