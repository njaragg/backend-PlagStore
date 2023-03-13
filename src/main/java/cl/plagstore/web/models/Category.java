package cl.plagstore.web.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//En la capa models (o entities), mapeamos todos las entidas de la base de datos
 
@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	//******  ATRIBUTOS  *****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	//******  RELAIONES  *****
	// Relacion uno a muchos con tabla products
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;
	
	//Getters, setters y constructores creados con Lombok
}
