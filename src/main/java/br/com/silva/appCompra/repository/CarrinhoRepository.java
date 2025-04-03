package br.com.silva.appCompra.repository;

import br.com.silva.appCompra.entity.user.Carrinho;
import br.com.silva.appCompra.entity.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {
    Optional<Carrinho> findByUsuario(Usuario usuario); //Permite buscar um carrinho pelo usuário.
}
