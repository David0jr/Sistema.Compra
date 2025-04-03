package br.com.silva.appCompra.entity.user;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    public Cliente(String nome, String email, String senha, Carrinho carrinho, Pedido pedido) {
        super(nome, email, senha, carrinho, pedido);
    }

    public Cliente() {

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
}
