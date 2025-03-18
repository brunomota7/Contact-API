package br.com.crud.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor //cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor //cria automaticamente um construtor vazio (sem argumentos).
@Data //cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Getter
@Setter
@Entity //pertence ao JPA e isso significa que a classe será automaticamente mapeada à tabela com o mesmo nome (classe Contact e tabela Contact).
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;


    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
