package com.franquicias.api.mapping;

import com.franquicias.api.Persistence.Entity.ProductoEntity;
import com.franquicias.api.dto.ProductoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

        public ProductoEntity toEntity(ProductoDTO productoDTO) {

            ProductoEntity productoEntity = new ProductoEntity();
            productoEntity.setId(productoDTO.getId());
            productoEntity.setNombre(productoDTO.getNombre());
            productoEntity.setStock(productoDTO.getStock());

            return productoEntity;
        }


        public ProductoDTO toDTO(ProductoEntity productoEntity) {

            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(productoEntity.getId());
            productoDTO.setNombre(productoEntity.getNombre());
            productoDTO.setStock(productoEntity.getStock());

            return productoDTO;
        }
    }


