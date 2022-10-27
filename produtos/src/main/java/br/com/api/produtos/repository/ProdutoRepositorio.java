package br.com.api.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.models.ProdutoModelo;

//mostrando para o spring que sera uma pasta de repositorio
@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long>  {
    
    int countById(Long id);
}
