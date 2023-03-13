package cl.plagstore.web.controllers;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.plagstore.web.services.CategoryService;



@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/sales")
    public ArrayList<Object[]> obtenerVentasPorCategoria() {
        return categoryService.obtenerVentasPorCategoria();
    }
}
