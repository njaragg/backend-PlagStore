package cl.plagstore.web.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
	
	//******  ATRIBUTOS  *****
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate date;
    
    private Integer status;
    
    //******  RELACIONES  *****
    
    //relacion con tabla clients, muchos a 1 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id") 
    private Client client;
    
    //relacion con tabla sales_products, 1 a muchos
    @JsonIgnore 
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleProduct> products;
    
    
    
    //Getters, setters y constructores creados con Lombok
}
