package com.ftv.pe1.f3_web.models.dao;

import com.ftv.pe1.f3_web.models.dto.FacturaDTO;
import com.ftv.pe1.f3_web.models.dto.OrdenVentaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class OrdenVentaDAO implements IOrdenVentaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<OrdenVentaDTO> listarOrdenes() {
        return em.createQuery("SELECT o FROM OrdenVentaDTO o", OrdenVentaDTO.class).getResultList();
    }

    @Override
    public List<OrdenVentaDTO> listarOrdenesConDetalleOrdenYFactura() {
        return em.createQuery("SELECT o FROM OrdenVentaDTO o JOIN FETCH o.detalleOrden JOIN FETCH o.factura", OrdenVentaDTO.class).getResultList();
    }

    @Override
    public List<OrdenVentaDTO> listarOrdenesPorCliente(Integer idCliente) {
        return em.createQuery(
                        "SELECT o FROM OrdenVentaDTO o " +
                                "LEFT JOIN FETCH o.factura f " +
                                "LEFT JOIN FETCH o.detalleOrden d", OrdenVentaDTO.class)
                .getResultList();
    }

    @Override
    public List<OrdenVentaDTO> listarOrdenesPorFechas(String fecha1S, String fecha2S) {
        LocalDateTime fecha1 = LocalDate.parse(fecha1S).atStartOfDay();
        LocalDateTime fecha2 = LocalDate.parse(fecha1S).atTime(23, 59, 59);
        return em.createQuery("SELECT o FROM OrdenVentaDTO o WHERE o.fecha BETWEEN :fecha1 AND :fecha2", OrdenVentaDTO.class)
                .setParameter("fecha1", fecha1)
                .setParameter("fecha2", fecha2)
                .getResultList();
    }

    @Override
    public List<OrdenVentaDTO> listarPorEstadoDePago(boolean pagado) {
        return em.createQuery(
                        "SELECT o FROM OrdenVentaDTO o " +
                                "LEFT JOIN o.factura f " +
                                "WHERE f.pagado = :pagado", OrdenVentaDTO.class)
                .setParameter("pagado", pagado)
                .getResultList();
    }

}
