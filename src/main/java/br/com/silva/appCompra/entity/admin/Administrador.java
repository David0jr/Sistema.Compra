package br.com.silva.appCompra.entity.admin;

import br.com.silva.appCompra.entity.user.Carrinho;
import br.com.silva.appCompra.entity.user.Pedido;
import br.com.silva.appCompra.entity.user.Usuario;
import jakarta.persistence.*;


import java.util.UUID;

@Entity
@Table (name = "administrador")
public class Administrador extends Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    public Administrador() {

    }

    public Administrador(String nome, String email, String senha, Carrinho carrinho, Pedido pedido) {
        super(nome, email, senha, carrinho, pedido);
    }


    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean autenticar() {
        return false;
    }

    @Override
    public boolean atualizarPerfil() {
        return false;
    }

    public void adicionarProduto (){}

    public void removerProduto(){}

    public void atualizarEstoque(){}
}
