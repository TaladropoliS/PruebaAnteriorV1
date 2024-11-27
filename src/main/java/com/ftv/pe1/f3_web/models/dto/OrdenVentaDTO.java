package com.ftv.pe1.f3_web.models.dto;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_venta")
public class OrdenVentaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_orden")
    private String numero_orden;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total")
    private Double total;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private ClienteDTO cliente;

    @OneToMany(mappedBy = "ordenVenta", cascade = CascadeType.ALL)
    private List<DetalleOrdenDTO> detalleOrden;

    @OneToMany(mappedBy = "ordenVenta", cascade = CascadeType.ALL)
    private List<FacturaDTO> factura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(String numero_orden) {
        this.numero_orden = numero_orden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<DetalleOrdenDTO> getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(List<DetalleOrdenDTO> detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public List<FacturaDTO> getFactura() {
        return factura;
    }

    public void setFactura(List<FacturaDTO> factura) {
        this.factura = factura;
    }
}
