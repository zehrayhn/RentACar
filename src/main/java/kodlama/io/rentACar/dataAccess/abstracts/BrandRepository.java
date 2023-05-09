package kodlama.io.rentACar.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;
// brandRepository de jpaRepositroy de interface o halde extend olmalı
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
	boolean existsByName(String name); //spring jpa keywords
	
	
}
