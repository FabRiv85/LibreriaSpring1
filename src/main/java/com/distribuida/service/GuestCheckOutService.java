package com.distribuida.service;

import com.distribuida.model.Factura;

public interface GuestCheckOutService {

    Factura checkoutbyToken(String token);

}
