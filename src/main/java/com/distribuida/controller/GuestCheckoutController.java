package com.distribuida.controller;

import com.distribuida.model.Factura;
import com.distribuida.service.GuestCheckOutService;
import com.distribuida.service.GuestCheckOutServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guest/checkout")
public class GuestCheckoutController {

    private  final GuestCheckOutService guestCheckOutService;

    public GuestCheckoutController(GuestCheckOutService service){
        this.guestCheckOutService=service;
    }

    @PostMapping
    public ResponseEntity<Factura>checkout(@RequestParam String token){
        return ResponseEntity.ok(guestCheckOutService.checkoutbyToken(token));
    }

}
