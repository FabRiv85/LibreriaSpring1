package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.model.Factura;
import com.distribuida.service.AutorService;
import com.distribuida.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;
    @GetMapping
    public ResponseEntity<List<Factura>> findAll(){
        List<Factura> factura1 = facturaService.findAll();
        return ResponseEntity.ok(factura1);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Factura> findOne(@PathVariable int id){
        Factura factura1= facturaService.findOne(id);
        if (factura1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factura1);
    }

    @PostMapping
    public ResponseEntity<Factura> save (@RequestBody Factura factura){
        Factura factura2 = facturaService.save(factura);
        return ResponseEntity.ok(factura2);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura>update(@PathVariable int id, @RequestBody Factura factura){
        Factura factura3= facturaService.save(factura);
        if (factura3 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factura3);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
