package com.franquicias.api.Persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Table(name = "Franquicia")
@Entity
public class FranquiciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SucursalEntity> sucursales = new ArrayList<>();

    public FranquiciaEntity(Long id, List<SucursalEntity> sucursales, String nombre) {
        this.id = id;
        this.sucursales = sucursales;
        this.nombre = nombre;
    }


    public void addSucursal(SucursalEntity sucursal) {
        sucursales.add(sucursal);
        sucursal.setFranquicia(this);
    }

    public void removeSucursal(SucursalEntity sucursal) {
        sucursales.remove(sucursal);
        sucursal.setFranquicia(null);
    }

    @Override
    public String toString() {
        return "Franquicias{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sucursales=" + sucursales +
                '}';
    }

    public FranquiciaEntity() {
    }
}
