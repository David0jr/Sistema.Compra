package br.com.silva.appCompra.repository;

import br.com.silva.appCompra.entity.user.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    List<Produto> findByNomeContainingIgnoreCase(String nome); //Permite buscar produtos pelo nome (busca parcial, sem diferenciar maiúsculas e minúsculas).
}
