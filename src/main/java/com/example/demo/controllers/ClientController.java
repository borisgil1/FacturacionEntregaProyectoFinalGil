package com.example.demo.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    public ClienteService clienteService;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping("/agregar")
    public String postCliente(@RequestBody Cliente cliente) {
        return clienteService.postCliente(cliente);
    }

    @PutMapping("/modificarCliente/{id}")
    public String updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/bajaCliente/{id}")
    public String deleteCliente(@PathVariable Long id) {
        return clienteService.deleteCliente(id);
    }
}
