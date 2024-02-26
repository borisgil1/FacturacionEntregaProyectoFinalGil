package com.example.demo.controllers;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    public ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @PostMapping("/alta/producto")
    public String postProducto(@RequestBody Producto producto) {
        return productoService.postProducto(producto);
    }

    @PutMapping("/modificarProducto/{id}")
    public String updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/bajaProducto/{id}")
    public String deleteProducto(@PathVariable Long id) {
        return productoService.deleteProducto(id);
    }

}
