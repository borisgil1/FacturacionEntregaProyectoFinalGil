package com.example.demo.service;
import com.example.demo.models.Venta;
import com.example.demo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime;

@org.springframework.stereotype.Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    public String postVenta(@RequestBody Venta venta) {
        ventaRepository.save(venta);
        return "Venta guardada";
    }

    public String updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Venta updateVenta = ventaRepository.findById(id).get();
        updateVenta.setCantidad(venta.getCantidad());
        updateVenta.setFecha(venta.getFecha());
        ventaRepository.save(updateVenta);
        return "Venta modificada";
    }

    public String deleteVenta(@PathVariable Long id) {

        Venta deleteVenta = ventaRepository.findById(id).get();
        ventaRepository.delete(deleteVenta);
        return "Venta eliminada";
    }

    LocalDateTime saleDate = getCurrentDateTime();

    private LocalDateTime getCurrentDateTime() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://worldclockapi.com/api/json/utc/now"))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            LocalDateTime currentDateTime = LocalDateTime.parse(json.substring(7, json.length() - 2), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();
            return LocalDateTime.now();
        }
    }
}
