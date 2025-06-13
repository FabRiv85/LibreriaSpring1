package com.distribuida.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "libro")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int idLibro;
    @Column(name = "titulo")
    private String tituLibro;
    @Column(name = "editorial")
    private String editoLibro;
    @Column(name = "num_paginas")
    private int pagLibro;
    @Column(name = "edicion")
    private String edicLibro;
    @Column(name = "idioma")
    private String idioLibro;
    @Column(name = "fecha_publicacion")
    private Date fecPubLibro;
    @Column(name = "descripcion")
    private String descLibro;
    @Column(name = "tipo_pasta")
    private String pastLibro;
    @Column(name = "isbn")
    private String isbnLibro;
    @Column(name = "num_ejemplares")
    private int numEjeLibro;
    @Column(name = "portada")
    private String portLibro;
    @Column(name = "presentacion")
    private String preseLibro;
    @Column(name = "precio")
    private Double precLibro;

    //patron de inyeccion de dependencias
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Libro(){

    }
    public Libro(int idLibro, String tituLibro, String editoLibro, int pagLibro, String edicLibro, String idioLibro, Date fecPubLibro, String descLibro,
                 String pastLibro, String isbnLibro, int numEjeLibro, String portLibro, String preseLibro, Double precLibro, Autor autor, Categoria categoria) {
        this.idLibro = idLibro;
        this.tituLibro = tituLibro;
        this.editoLibro = editoLibro;
        this.pagLibro = pagLibro;
        this.edicLibro = edicLibro;
        this.idioLibro = idioLibro;
        this.fecPubLibro = fecPubLibro;
        this.descLibro = descLibro;
        this.pastLibro = pastLibro;
        this.isbnLibro = isbnLibro;
        this.numEjeLibro = numEjeLibro;
        this.portLibro = portLibro;
        this.preseLibro = preseLibro;
        this.precLibro = precLibro;
        this.autor = autor;
        this.categoria = categoria;
    }
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public String getTituLibro() {
        return tituLibro;
    }
    public void setTituLibro(String tituLibro) {
        this.tituLibro = tituLibro;
    }
    public String getEditoLibro() {
        return editoLibro;
    }
    public void setEditoLibro(String editoLibro) {
        this.editoLibro = editoLibro;
    }
    public int getPagLibro() {
        return pagLibro;
    }
    public void setPagLibro(int pagLibro) {
        this.pagLibro = pagLibro;
    }
    public String getEdicLibro() {
        return edicLibro;
    }
    public void setEdicLibro(String edicLibro) {
        this.edicLibro = edicLibro;
    }
    public String getIdioLibro() {
        return idioLibro;
    }
    public void setIdioLibro(String idioLibro) {
        this.idioLibro = idioLibro;
    }
    public Date getFecPubLibro() {
        return fecPubLibro;
    }
    public void setFecPubLibro(Date fecPubLibro) {
        this.fecPubLibro = fecPubLibro;
    }
    public String getDescLibro() {
        return descLibro;
    }
    public void setDescLibro(String descLibro) {
        this.descLibro = descLibro;
    }
    public String getPastLibro() {
        return pastLibro;
    }
    public void setPastLibro(String pastLibro) {
        this.pastLibro = pastLibro;
    }
    public String getIsbnLibro() {
        return isbnLibro;
    }
    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }
    public int getNumEjeLibro() {
        return numEjeLibro;
    }
    public void setNumEjeLibro(int numEjeLibro) {
        this.numEjeLibro = numEjeLibro;
    }
    public String getPortLibro() {
        return portLibro;
    }
    public void setPortLibro(String portLibro) {
        this.portLibro = portLibro;
    }
    public String getPreseLibro() {
        return preseLibro;
    }
    public void setPreseLibro(String preseLibro) {
        this.preseLibro = preseLibro;
    }
    public Double getPrecLibro() {
        return precLibro;
    }
    public void setPrecLibro(Double precLibro) {
        this.precLibro = precLibro;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", tituLibro='" + tituLibro + '\'' +
                ", editoLibro='" + editoLibro + '\'' +
                ", pagLibro=" + pagLibro +
                ", edicLibro='" + edicLibro + '\'' +
                ", idioLibro='" + idioLibro + '\'' +
                ", fecPubLibro=" + fecPubLibro +
                ", descLibro='" + descLibro + '\'' +
                ", pastLibro='" + pastLibro + '\'' +
                ", isbnLibro='" + isbnLibro + '\'' +
                ", numEjeLibro=" + numEjeLibro +
                ", portLibro='" + portLibro + '\'' +
                ", preseLibro='" + preseLibro + '\'' +
                ", precLibro=" + precLibro +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}
