package com.ftv.pe1.f3_web.models.services;

import com.ftv.pe1.f3_web.models.dto.OrdenVentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrdenService {

    public List<OrdenVentaDTO> listarOrdenes();

    public List<OrdenVentaDTO> listarOrdenesConDetalleOrdenYFactura();

    public List<OrdenVentaDTO> listarOrdenesPorCliente(Integer idCliente);

    public List<OrdenVentaDTO> listarOrdenesPorFechas(String fecha1, String fecha2);

    public List<OrdenVentaDTO> listarPorEstadoDePago(boolean pagado);

}
