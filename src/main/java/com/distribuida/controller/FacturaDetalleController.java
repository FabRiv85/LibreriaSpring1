package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.model.FacturaDetalle;
import com.distribuida.service.AutorService;
import com.distribuida.service.FacturaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class FacturaDetalleController {
    @Autowired
    private FacturaDetalleService facturaDetalleService;
    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findAll(){
        List<FacturaDetalle> facturaDetalle1 = facturaDetalleService.findAll();
        return ResponseEntity.ok(facturaDetalle1);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<FacturaDetalle> findOne(@PathVariable int id){
        FacturaDetalle facturaDetalle1= facturaDetalleService.findOne(id);
        if (facturaDetalle1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDetalle1);
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> save (@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle facturaDetalle2 = facturaDetalleService.save(facturaDetalle);
        return ResponseEntity.ok(facturaDetalle2);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle>update(@PathVariable int id, @RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle facturaDetalle3= facturaDetalleService.save(facturaDetalle);
        if (facturaDetalle3 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDetalle3);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
