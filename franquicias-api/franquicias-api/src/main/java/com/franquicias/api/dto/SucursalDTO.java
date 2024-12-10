package com.franquicias.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDTO {
    private Long id;
    private String nombre;
    private List<ProductoDTO> productos;
}
