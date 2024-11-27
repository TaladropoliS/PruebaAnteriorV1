package com.ftv.pe1.f3_web.models.dao;

import com.ftv.pe1.f3_web.models.dto.FacturaDTO;
import com.ftv.pe1.f3_web.models.dto.OrdenVentaDTO;

import java.util.List;

public interface IOrdenVentaDAO {

    public List<OrdenVentaDTO> listarOrdenes();

    public List<OrdenVentaDTO> listarOrdenesConDetalleOrdenYFactura();

    public List<OrdenVentaDTO> listarOrdenesPorCliente(Integer idCliente);

    public List<OrdenVentaDTO> listarOrdenesPorFechas(String fecha1, String fecha2);

    public List<OrdenVentaDTO> listarPorEstadoDePago(boolean pagado);

}
