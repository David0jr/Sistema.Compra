package br.com.silva.appCompra.entity.user;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table (name = "Pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Column(name = "valor", precision = 6, scale = 2)
    private BigDecimal valor;

    @Column(length = 100)
    private String metodo;

    @Column(length = 100)
    private String status;

    public Pagamento() {
    }

    public Pagamento(UUID id, Pedido pedido, double valor, String metodo, String status) {
        this.id = id;
        this.pedido = pedido;
        this.valor = BigDecimal.valueOf(valor);
        this.metodo = metodo;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = BigDecimal.valueOf(valor);
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean processarPagamento(){
        return true;
    }
}
