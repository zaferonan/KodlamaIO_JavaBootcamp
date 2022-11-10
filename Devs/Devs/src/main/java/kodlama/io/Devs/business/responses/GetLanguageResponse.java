package kodlama.io.Devs.business.responses;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLanguageResponse {

	private int languageId;
	private String languageName;
}
