package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
//ctrl shift o kullanılımayan importları kaldırır
	private BrandService brandService;

//	@Autowired//kim brandservice i implemente ediyor onu bulur
//	public BrandsController(BrandService brandService) {
//		
//		this.brandService = brandService;
//	}
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		//spring IoC 
		return brandService.getAll();
	}
	
	//{id}<- bu gösterim değişkeni temsil eder. parantez içine yazdığımız @PathVariable ile bu değişkeni nereden(api/brand/{id}) almamız gerektiğini söyleriz
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){
		//spring IoC 
		return brandService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PutMapping()
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}
