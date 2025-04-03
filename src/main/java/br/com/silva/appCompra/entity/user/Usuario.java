package br.com.silva.appCompra.entity.user;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Define a herança com tabelas separadas
public abstract class Usuario { // Tornando a classe abstrata

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 240)
    private String nome;

    @Column(length = 240)
    private String email;

    @Column(length = 100)
    private String senha;

    @OneToOne
    @JoinColumn(name = "id_carrinho")
    private Carrinho carrinho;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Carrinho carrinho) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.carrinho = carrinho;
    }

    public Usuario(String nome, String email, String senha, Carrinho carrinho, Pedido pedido) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.carrinho = carrinho;
        this.pedidos.add(pedido);
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // Métodos abstratos: as subclasses devem implementar
    public abstract boolean autenticar();
    public abstract boolean atualizarPerfil();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", carrinho=" + carrinho +
                ", pedidos=" + pedidos +
                '}';
    }
}
