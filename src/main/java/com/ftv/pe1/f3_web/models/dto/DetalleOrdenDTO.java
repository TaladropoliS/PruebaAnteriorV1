package com.ftv.pe1.f3_web.models.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrdenDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private Double precio_unitario;

    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoDTO producto;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private OrdenVentaDTO ordenVenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public OrdenVentaDTO getOrdenVenta() {
        return ordenVenta;
    }

    public void setOrdenVenta(OrdenVentaDTO ordenVenta) {
        this.ordenVenta = ordenVenta;
    }
}
