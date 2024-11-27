package com.ftv.pe1.f3_web.models.services;

import com.ftv.pe1.f3_web.models.dao.IOrdenVentaDAO;
import com.ftv.pe1.f3_web.models.dto.OrdenVentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrdenVentaSERVICE")
public class OrdenService implements IOrdenService {

    @Autowired
    private IOrdenVentaDAO ordenVentaDAO;

    @Override
    public List<OrdenVentaDTO> listarOrdenes() {
        return ordenVentaDAO.listarOrdenes();
    }

    @Override
    public List<OrdenVentaDTO> listarOrdenesConDetalleOrdenYFactura() {
        return ordenVentaDAO.listarOrdenesConDetalleOrdenYFactura();
    }

    @Override
    public List<OrdenVentaDTO> listarOrdenesPorCliente(Integer idCliente) {
        return ordenVentaDAO.listarOrdenesPorCliente(idCliente);
    }

    @Override
    public List<OrdenVentaDTO> listarOrdenesPorFechas(String fecha1, String fecha2) {
        return ordenVentaDAO.listarOrdenesPorFechas(fecha1, fecha2);
    }

    @Override
    public List<OrdenVentaDTO> listarPorEstadoDePago(boolean pagado) {
        return ordenVentaDAO.listarPorEstadoDePago(pagado);
    }
}
