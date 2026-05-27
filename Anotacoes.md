Essa será a arquitetura do projeto:
![img.png](img.png)

- O banco de dados local H2 pode ser acessado em [localhost:8080/h2-console](http://localhost:8080/h2-console)
- `@Autowired` realiza a injeção de dependência automaticamente. A classe que vai ser injetada deve estar registrada como componente do Spring, com `@Component` ou `@Service` ou outra coisa
- 