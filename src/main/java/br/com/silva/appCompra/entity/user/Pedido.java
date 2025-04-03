package br.com.silva.appCompra.entity.user;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP) //Mapeamento de data
    @Column(name = "data_criacao")
    private Date data;

    @Column(length = 40) //Definindo o tamanho de amarzenamento da String no banco
    private String status;

    @ManyToOne //
    @JoinColumn (name = "id_cliente")
    private Usuario cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedido = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;

    public Pedido() {
    }

    public Pedido(UUID id, Date data, String status, Usuario cliente, Pagamento pagamento) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public double calcularTotal(){
        return 0.0;
    }

    public void atualizarStatus(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
