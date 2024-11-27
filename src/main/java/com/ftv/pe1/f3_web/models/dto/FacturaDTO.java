package com.ftv.pe1.f3_web.models.dto;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "factura")
public class FacturaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_factura")
    private String numero_factura;

    @Column(name = "fecha_emision")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_emision;

    @Column(name = "monto_total")
    private Double monto_total;

    @Column(name = "pagado")
    private Boolean pagado;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private OrdenVentaDTO ordenVenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public OrdenVentaDTO getOrdenVenta() {
        return ordenVenta;
    }

    public void setOrdenVenta(OrdenVentaDTO ordenVenta) {
        this.ordenVenta = ordenVenta;
    }
}
