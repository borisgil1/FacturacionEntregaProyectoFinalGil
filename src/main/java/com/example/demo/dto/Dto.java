package com.example.demo.dto;
import java.util.List;

public class Dto {
    private Long clienteId;
    private List<Long> productosIds;
    private int cantidad;
    private double total;

    public Dto(Long clientId, List<Long> productIds, int quantity, double total) {
        this.clienteId = clientId;
        this.productosIds = productIds;
        this.cantidad = quantity;
        this.total = total;
    }

    public Long getClientId() {
        return clienteId;
    }

    public List<Long> getProductIds() {
        return productosIds;
    }

    public int getQuantity() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }
}