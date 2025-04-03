package br.com.silva.appCompra.repository;

import br.com.silva.appCompra.entity.user.ItemPedido;
import br.com.silva.appCompra.entity.user.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, UUID> {
    List<ItemPedido> findByPedido(Pedido pedido); //Permite buscar todos os itens de um pedido específico.
}
