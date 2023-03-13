package cl.plagstore.web.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
	//******  ATRIBUTOS  *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private BigDecimal price; //Se usa BigDecimal porque este tipo de dato es mas preciso en cuanto a calculos numericos, y como se trabaja con dinero, necesitamos exactitud
    
    //******  RELACIONES  *****
    
    //relacion muchos a uno con tabla categories
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    
    
    // Relacion uno a muchos con tabla sale_products
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleProduct> saleProducts;
    
//Getters, setters y constructores creados con Lombok

}
