package com.bandtec.darlingjob.gateway.repository;

import com.bandtec.darlingjob.gateway.repository.dominio.GastoFixo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GastoFixoRepository extends JpaRepository<GastoFixo, Integer> {
    List<GastoFixo> findByUsuario_IdUsuario(Integer idUsuario);
}