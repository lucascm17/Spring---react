package br.com.api.produtos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//criando a tabela
@Entity
//mudando o nome da tabela
@Table(name = "produtos")
//criando os getters e setters atraves do lombok
@Getter
@Setter
public class ProdutoModelo {
    
    //atributos

    //tornado chave primaria
    @Id
    //tornando a chave primaria como autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;

}
