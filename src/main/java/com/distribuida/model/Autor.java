package com.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private int idAutor;
    @Column(name = "nombre")
    private String nomAutor;
    @Column(name = "apellido")
    private String apeAutor;
    @Column(name = "pais")
    private String paisAutor;
    @Column(name = "direccion")
    private String dirAutor;
    @Column(name = "telefono")
    private String fonoAutor;
    @Column(name = "correo")
    private String correoAutor;

    public Autor(){

    }
    public Autor(int idAutor, String nomAutor, String apeAutor, String paisAutor, String dirAutor, String fonoAutor, String correoAutor) {
        this.idAutor = idAutor;
        this.nomAutor = nomAutor;
        this.apeAutor = apeAutor;
        this.paisAutor = paisAutor;
        this.dirAutor = dirAutor;
        this.fonoAutor = fonoAutor;
        this.correoAutor = correoAutor;
    }
    public int getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    public String getNomAutor() {
        return nomAutor;
    }
    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }
    public String getApeAutor() {
        return apeAutor;
    }
    public void setApeAutor(String apeAutor) {
        this.apeAutor = apeAutor;
    }
    public String getPaisAutor() {
        return paisAutor;
    }
    public void setPaisAutor(String paisAutor) {
        this.paisAutor = paisAutor;
    }
    public String getDirAutor() {
        return dirAutor;
    }
    public void setDirAutor(String dirAutor) {
        this.dirAutor = dirAutor;
    }
    public String getFonoAutor() {
        return fonoAutor;
    }
    public void setFonoAutor(String fonoAutor) {
        this.fonoAutor = fonoAutor;
    }
    public String getCorreoAutor() {
        return correoAutor;
    }
    public void setCorreoAutor(String correoAutor) {
        this.correoAutor = correoAutor;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nomAutor='" + nomAutor + '\'' +
                ", apeAutor='" + apeAutor + '\'' +
                ", paisAutor='" + paisAutor + '\'' +
                ", dirAutor='" + dirAutor + '\'' +
                ", fonoAutor='" + fonoAutor + '\'' +
                ", correoAutor='" + correoAutor + '\'' +
                '}';
    }
}
