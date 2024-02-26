package com.example.demo.service;
import com.example.demo.models.Cliente;;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@org.springframework.stereotype.Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public String postCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return "Cliente guardado";
    }

    public String updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updateCliente = clienteRepository.findById(id).get();
        updateCliente.setNombre(cliente.getNombre());
        updateCliente.setEmail(cliente.getEmail());
        clienteRepository.save(updateCliente);
        return "Cliente modificado";
    }

    public String deleteCliente(@PathVariable Long id) {

        Cliente deleteCliente = clienteRepository.findById(id).get();
        clienteRepository.delete(deleteCliente);
        return "Cliente eliminado";
    }

    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }
}
