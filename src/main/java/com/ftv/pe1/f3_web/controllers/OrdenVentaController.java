package com.ftv.pe1.f3_web.controllers;

import com.ftv.pe1.f3_web.models.services.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrdenVentaController {

    @Autowired
    @Qualifier("OrdenVentaSERVICE")
    private IOrdenService ordenService;

    @GetMapping("/ordenes")
    public String listarOrdenes(Model model) {
        model.addAttribute("titulo", "Listado de Ordenes");
        model.addAttribute("ordenes", ordenService.listarOrdenes());
//        model.addAttribute("ordenes", ordenService.listarPorEstadoDePago(false));
//        model.addAttribute("ordenes", ordenService.listarPorEstadoDePago(true));
        return "ordenes";
    }

    @PostMapping("ordenesPorFechas")
    public String listarOrdenes(Model model, @RequestParam String fecha1, @RequestParam String fecha2) {
        model.addAttribute("titulo", "Listado de Ordenes Por Fecha");
        model.addAttribute(
                "ordenes",
                ordenService.listarOrdenesPorFechas(fecha1, fecha2));
        return "ordenes";
    }
}
