package cl.plagstore.web.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.plagstore.web.services.SaleService;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @GetMapping("/last15") 
    public ArrayList<Object[]>  obtener15UltimosRegistros() {
        return saleService.obetener15UltimosRegistros();
    }
}