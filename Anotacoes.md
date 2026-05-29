Essa será a arquitetura do projeto:
![img.png](img.png)

- O banco de dados local H2 pode ser acessado em [localhost:8080/h2-console](http://localhost:8080/h2-console)
- `@Autowired` realiza a injeção de dependência automaticamente. A classe que vai ser injetada deve estar registrada como componente do Spring, com `@Component` ou `@Service` ou outra coisa
- Essa costuma ser a implementação padrão de um Enum, e resolve o problema de 'Um novo enum é adicionado no meio, então todos os enums na frente dele mudam de número'
```java
public enum OrderStatus {
  WAITING_PAYMENT(1),
  PAID(2),
  SHIPPED(3),
  DELIVERED(4),
  CANCELLED(5);

  private int code;

  OrderStatus(int code) {
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }

  public static OrderStatus valueOf(int code) {
      for (OrderStatus value : OrderStatus.values())
        if (value.getCode() == code)
            return value;
    
      throw new IllegalArgumentException();
  }
}
```
