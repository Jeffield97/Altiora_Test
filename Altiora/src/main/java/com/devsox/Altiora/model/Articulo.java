package com.devsox.Altiora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.math.BigDecimal;
import java.util.List;
@Entity
public class Articulo {
    @Id
    private String codigo;
    private String nombre;
    private BigDecimal precioUnitario;

    @ManyToMany(mappedBy = "articulos")
    private List<Orden> ordenes;

    public Articulo(String codigo, String nombre, BigDecimal precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }
    public  Articulo ()
    {}
//Métodos getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
}
