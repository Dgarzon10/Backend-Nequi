package com.franquicias.api.mapping;

import com.franquicias.api.Persistence.Entity.FranquiciaEntity;
import com.franquicias.api.Persistence.Entity.SucursalEntity;
import com.franquicias.api.dto.SucursalDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SucursalMapper {

    public SucursalEntity toEntity(SucursalDTO sucursalDTO, FranquiciaEntity franquiciaEntity){

        SucursalEntity sucursalEntity = new SucursalEntity();
        sucursalEntity.setId(sucursalDTO.getId());
        sucursalEntity.setNombre(sucursalDTO.getNombre());
        sucursalEntity.setFranquicia(franquiciaEntity);
        sucursalEntity.setProductos(sucursalDTO.getProductos().stream()
                .map( productoDTO  -> new ProductoMapper().toEntity(productoDTO,sucursalEntity))
                .collect(Collectors.toList()));

        return sucursalEntity;
    }

    public SucursalDTO toDTO(SucursalEntity sucursalEntity){

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setId(sucursalEntity.getId());
        sucursalDTO.setNombre(sucursalEntity.getNombre());
        sucursalDTO.setFranquicia_id(sucursalEntity.getFranquicia().getId());
        sucursalDTO.setProductos(sucursalEntity.getProductos().stream()
                .map(productoEntity -> new ProductoMapper().toDTO(productoEntity))
                .collect(Collectors.toList()));

        return sucursalDTO;
    }
}
