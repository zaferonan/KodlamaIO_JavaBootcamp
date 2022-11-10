package kodlama.io.Devs.business.responses;

import kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSubTechnologyResponse {

	private int subTechnologyId;

	private String subTechnologyName;

	private GetLanguageResponse getLanguageResponse;
}
