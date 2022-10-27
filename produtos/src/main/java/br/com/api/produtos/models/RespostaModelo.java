package br.com.api.produtos.models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// utilizar a injeção de dependencia
@Component
@Getter
@Setter
public class RespostaModelo {
    
    private String mensagem;
}
