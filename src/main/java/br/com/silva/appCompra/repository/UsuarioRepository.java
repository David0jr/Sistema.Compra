package br.com.silva.appCompra.repository;

import br.com.silva.appCompra.entity.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email); //Permite buscar um usuário pelo email
}
