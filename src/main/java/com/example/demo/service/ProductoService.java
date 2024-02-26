package com.example.demo.service;
import com.example.demo.models.Cliente;
import com.example.demo.models.Producto;
import com.example.demo.models.Venta;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@org.springframework.stereotype.Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public String postProducto(@RequestBody Producto producto) {
        productoRepository.save(producto);
        return "Producto guardado";
    }

    public String updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updateProducto = productoRepository.findById(id).get();
        updateProducto.setNombre(producto.getNombre());
        updateProducto.setPrecio(producto.getPrecio());
        productoRepository.save(updateProducto);
        return "Producto modificado";
    }

    public String deleteProducto(@PathVariable Long id) {

        Producto deleteProducto = productoRepository.findById(id).get();
        productoRepository.delete(deleteProducto);
        return "Producto eliminado";
    }
}
