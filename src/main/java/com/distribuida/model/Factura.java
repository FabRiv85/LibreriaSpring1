package com.distribuida.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int idFactura;
    @Column(name = "num_factura")
    private String numFactura;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "total_neto")
    private double totalNeto;
    @Column(name = "iva")
    private double iva;
    @Column(name = "total")
    private double total;

    //patron de inyeccion de dependencias
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    public Factura( ) {
    }

    public Factura(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total, Cliente cliente) {
        this.idFactura = idFactura;
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.totalNeto = totalNeto;
        this.iva = iva;
        this.total = total;
        this.cliente = cliente;
    }

    public int getIdFactura() {
        return idFactura;
    }
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    public String getNumFactura() {
        return numFactura;
    }
    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getTotalNeto() {
        return totalNeto;
    }
    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }
    public double getIva() {
        return iva;
    }
    public void setIva(double iva) {
        this.iva = iva;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    //Metodo inyector de dependencias
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", numFactura='" + numFactura + '\'' +
                ", fecha=" + fecha +
                ", totalNeto=" + totalNeto +
                ", iva=" + iva +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
