package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="brands")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

	@Id//veritabanında primary key alanısın
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ıd nin otomatik arttırılmasını anlatır.
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	

	@OneToMany(mappedBy = "brand")
	List<Model> models;
	
	
}
