package com.example.demo.controllers;
import com.example.demo.models.Venta;
import com.example.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime;

@org.springframework.stereotype.Service
public class VentaController {

    @Autowired
    public VentaService ventaService;

    @GetMapping("/ventas")
    public List<Venta> getVentas() {
        return ventaService.getVentas();
    }

    @PostMapping("/alta/venta")
    public String postVenta(@RequestBody Venta venta) {
        return ventaService.postVenta(venta);
    }

    @PutMapping("/modificarVenta/{id}")
    public String updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return ventaService.updateVenta(id, venta);
    }

    @DeleteMapping("/bajaVenta/{id}")
    public String deleteVenta(@PathVariable Long id) {
        return ventaService.deleteVenta(id);
    }
}