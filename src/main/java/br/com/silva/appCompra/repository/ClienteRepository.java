package br.com.silva.appCompra.repository;

import br.com.silva.appCompra.entity.user.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // Define que esta interface é um repositório Spring
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
