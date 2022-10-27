package br.com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.models.ProdutoModelo;
import br.com.api.produtos.models.RespostaModelo;
import br.com.api.produtos.repository.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    //metodo para listar todos os produtos
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    //metoso para cadstro e alteração de produtos
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){

        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatorio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatorio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);

            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);

            }
        }

    }

    //metodo para remover regitrps 
    public ResponseEntity<RespostaModelo> remover(Long id){
        if(pr.countById(id) == 0 ){
            rm.setMensagem("codigo não encontrado, digite um codigo valido");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.NOT_FOUND);
        }else{
            pr.deleteById(id); 
            rm.setMensagem("Produto removido com sucesso"); // retornando uma mensagem pois o delete é do tipo void
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
        }
    }
}
