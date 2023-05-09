package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

	private ModelMapper modelMapper;
	
	//gevşek-> istenilen alanları alır sadece
	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return this.modelMapper;
	}

	//standart->tümünü alır ve tümü alınmazsa uyarı verir.
	@Override
	public ModelMapper forRequest() {
	    this.modelMapper.getConfiguration()
	    .setAmbiguityIgnored(true)
	    .setMatchingStrategy(MatchingStrategies.STANDARD);
		
	    return this.modelMapper;
	}

}
