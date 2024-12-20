package com.franquicias.api.Persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "Sucursal")
public class SucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "franquicia_id", nullable = false)
    private FranquiciaEntity franquicia;


    @OneToMany(mappedBy = "sucursal",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoEntity> productos = new ArrayList<>();

    public void addProducto(ProductoEntity producto) {
        productos.add(producto);
        producto.setSucursal(this);
    }

    public void removeProducto(ProductoEntity producto) {
        productos.remove(producto);
        producto.setSucursal(null);
    }

    public void setFranquicia(FranquiciaEntity franquicia) {
        this.franquicia = franquicia;
    }

    @Override
    public String toString() {
        return "Sucursales{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", franquicia=" + franquicia +
                ", productos=" + productos +
                '}';
    }

    public SucursalEntity() {
    }


    //ERROR SET y GET


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

    public FranquiciaEntity getFranquicia() {
        return franquicia;
    }

    public List<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoEntity> productos) {
        this.productos = productos;
    }
}
