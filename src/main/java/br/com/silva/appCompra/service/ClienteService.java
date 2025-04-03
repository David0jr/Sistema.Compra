package br.com.silva.appCompra.service;

import br.com.silva.appCompra.controller.CreateClienteDto;
import br.com.silva.appCompra.entity.user.Cliente;
import br.com.silva.appCompra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // Define que essa classe é um serviço gerenciado pelo Spring.
public class ClienteService {

    @Autowired // Injeção de dependência do repositório
    private ClienteRepository clienteRepository;

    // Método para criar um cliente
    public Cliente criarCliente(CreateClienteDto createClienteDto) {//Recebe um CreateClienteDto (DTO contendo nome, email e senha).
        Cliente cliente = new Cliente(createClienteDto.nome(), createClienteDto.email(), createClienteDto.senha());
        return clienteRepository.save(cliente);
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Optional<Cliente> buscarClientePorId(UUID id) {
        return clienteRepository.findById(id);
    }

    // Deletar cliente por ID
    public void deletarCliente(UUID id) {
        clienteRepository.deleteById(id);
    }
}
