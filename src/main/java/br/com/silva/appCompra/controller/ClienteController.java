package br.com.silva.appCompra.controller;

import br.com.silva.appCompra.entity.user.Cliente;
import br.com.silva.appCompra.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Define que esta classe é um controlador REST
@RequestMapping("/cliente") // Todos os endpoints terão esse prefixo
public class ClienteController {

    @Autowired // Injeção de dependência do serviço
    private ClienteService clienteService;

    // Criar cliente
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody CreateClienteDto createClienteDto) {
        Cliente novoCliente = clienteService.criarCliente(createClienteDto);
        return ResponseEntity.ok(novoCliente);
    }

    // Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable UUID id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable UUID id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
