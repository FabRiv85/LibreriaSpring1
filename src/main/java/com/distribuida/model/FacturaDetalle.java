package com.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "factura_detalle")
public class FacturaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura_detalle")
    private int idFacDet;
    @Column(name = "cantidad")
    private int cantFacDet;
    @Column(name = "subtotal")
    private double subtFacDet;
   //
    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;
    //
    public FacturaDetalle() {

    }
    public FacturaDetalle(int idFacDet, int cantFacDet, double subtFacDet, Factura factura1, Libro libro) {
        this.idFacDet = idFacDet;
        this.cantFacDet = cantFacDet;
        this.subtFacDet = subtFacDet;
        this.factura = factura;
        this.libro = libro;
    }
    public int getIdFacDet() {
        return idFacDet;
    }
    public void setIdFacDet(int idFacDet) {
        this.idFacDet = idFacDet;
    }
    public int getCantFacDet() {
        return cantFacDet;
    }
    public void setCantFacDet(int cantFacDet) {
        this.cantFacDet = cantFacDet;
    }
    public double getSubtFacDet() {
        return subtFacDet;
    }
    public void setSubtFacDet(double subtFacDet) {
        this.subtFacDet = subtFacDet;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    @Override
    public String toString() {
        return "FacturaDetalle{" +
                "idFacDet=" + idFacDet +
                ", cantFacDet=" + cantFacDet +
                ", subtFacDet=" + subtFacDet +
                ", factura=" + factura +
                ", libro=" + libro +
                '}';
    }
}
