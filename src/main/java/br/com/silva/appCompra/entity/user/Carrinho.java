package br.com.silva.appCompra.entity.user;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carrinhos")
public class Carrinho implements Serializable {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private List<ItemCarrinho> item = new ArrayList<>();



    public Carrinho() {
    }

    public Carrinho(Usuario usuario) {
        this.usuario = usuario;
        this.item = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemCarrinho> getItem() {
        return item;
    }

    public void setItem(List<ItemCarrinho> item) {
        this.item = item;
    }

    public void adicionarItem(ItemCarrinho Item){
        item.add(Item);
    }

    public void removerItem(ItemCarrinho Item){
        item.remove(Item);
    }

    public double calcularTotal(){

        return 0.0;
    }

    public void esvaziarCarrinho(){

    }

    public void finalizarCompra(){

    }


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
