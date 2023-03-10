package cl.plagstore.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.plagstore.web.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/sales")
    public List<Object[]> obtenerProductoMasVendidoDesc() {
        List<Object[]> products = productService.obtenerProductoMasVendidoDesc();
        return products;
    }

}
