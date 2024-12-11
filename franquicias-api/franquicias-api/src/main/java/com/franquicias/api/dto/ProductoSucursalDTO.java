package com.franquicias.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoSucursalDTO {
    private String nombreSucursal;
    private String nombreProducto;
    private Integer stock;

    public ProductoSucursalDTO(String nombreSucursal, String nombreProducto, Integer stock) {
        this.nombreSucursal = nombreSucursal;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
    }

    public ProductoSucursalDTO() {
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
