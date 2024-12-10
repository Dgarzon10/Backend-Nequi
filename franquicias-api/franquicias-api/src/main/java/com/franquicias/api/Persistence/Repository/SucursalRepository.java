package com.franquicias.api.Persistence.Repository;

import com.franquicias.api.Persistence.Entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<SucursalEntity, Long> {
}
