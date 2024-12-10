package com.franquicias.api.Persistence.Repository;

import com.franquicias.api.Persistence.Entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
