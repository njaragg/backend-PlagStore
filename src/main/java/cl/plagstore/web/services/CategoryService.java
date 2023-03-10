package cl.plagstore.web.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.plagstore.web.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public ArrayList<Object[]> obtenerVentasPorCategoria() {
    	ArrayList<Object[]> results = categoryRepository.obtenerVentasPorCategoria();
        return results;
    }
}


