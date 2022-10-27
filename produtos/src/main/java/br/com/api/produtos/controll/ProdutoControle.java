package br.com.api.produtos.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.models.ProdutoModelo;
import br.com.api.produtos.models.RespostaModelo;
import br.com.api.produtos.service.ProdutoServico;

//responsavel por criar rotas
@RestController
@CrossOrigin(origins = "*") // liberando a api para livre acesso, evitando o problema de cors
public class ProdutoControle {

    //utiçizando a injeção de dependencia
    @Autowired
    private ProdutoServico ps;

    @DeleteMapping("/removerProdutos/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return ps.remover(id);
    }

    @PutMapping("/alterarProdutos")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }


    @PostMapping("/cadastroProdutos")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    @GetMapping("/produtos")
    public Iterable<ProdutoModelo> listat(){
        return ps.listar();
    }

    
    @GetMapping("/")
    public String rota(){
        return "API de produtos esta funcionando";
    }
}
