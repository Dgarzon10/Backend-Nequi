package com.franquicias.api.Persistence.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Setter
@Getter
@Table(name = "Producto")
@Entity
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer Stock;

    @ManyToOne
    @JoinColumn(name = "sucursal_id",nullable = false)
    private SucursalEntity sucursal;

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public ProductoEntity(Long id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        Stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(Stock, that.Stock) && Objects.equals(sucursal, that.sucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, Stock, sucursal);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Stock=" + Stock +
                '}';
    }

    public ProductoEntity() {
    }

    // ERROR SET y GET


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }
}
