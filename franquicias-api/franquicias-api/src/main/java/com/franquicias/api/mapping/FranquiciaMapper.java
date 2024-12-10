package com.franquicias.api.mapping;

import com.franquicias.api.Persistence.Entity.FranquiciaEntity;
import com.franquicias.api.dto.FranquiciaDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FranquiciaMapper {

    public FranquiciaEntity toEntity(FranquiciaDTO franquiciaDTO){

        FranquiciaEntity franquiciaEntity = new FranquiciaEntity();
        franquiciaEntity.setId(franquiciaDTO.getId());
        franquiciaEntity.setNombre(franquiciaDTO.getNombre());
        franquiciaEntity.setSucursales(franquiciaDTO.getSucursales().stream()
                .map(sucursalDTO -> new SucursalMapper().toEntity(sucursalDTO))
                .collect(Collectors.toList()));

        return franquiciaEntity;
    }

    public FranquiciaDTO toDTO(FranquiciaEntity franquiciaEntity){

        FranquiciaDTO franquiciaDTO = new FranquiciaDTO();
        franquiciaDTO.setId(franquiciaEntity.getId());
        franquiciaDTO.setNombre(franquiciaEntity.getNombre());
        franquiciaDTO.setSucursales(franquiciaEntity.getSucursales().stream()
                .map(sucursalEntity -> new SucursalMapper().toDTO(sucursalEntity))
                .collect(Collectors.toList()));

        return franquiciaDTO;
    }
}
