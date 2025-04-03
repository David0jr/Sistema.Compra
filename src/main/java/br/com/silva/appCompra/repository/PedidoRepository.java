package br.com.silva.appCompra.repository;

import br.com.silva.appCompra.entity.user.Pedido;
import br.com.silva.appCompra.entity.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    List<Pedido> findByCliente(Usuario cliente); //Permite buscar todos os pedidos de um determinado cliente
}
