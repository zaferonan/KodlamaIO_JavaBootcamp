package kodlama.io.Devs.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubTechnologyRequest {

	@NotBlank
	@NotNull
	@NotEmpty
	private int subTechnologyId;
	
	@NotBlank
	@NotNull
	@NotEmpty
	private String subTechnologyName;

	@NotBlank
	@NotNull
	@NotEmpty
	private int language_id;
}
