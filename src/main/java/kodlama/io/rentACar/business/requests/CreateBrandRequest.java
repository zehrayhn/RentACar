package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//son kullanıcıdan data alıyorsak request ona bir şey veriyorsak response
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandRequest {
	@NotNull
	@NotBlank
	@Size(min=3,max=20)
	private String name;

	
	
}
