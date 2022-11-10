package kodlama.io.Devs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Language")
@Entity
public class Language {
	
	@Id
	@Column(name = "language_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageId;
	
	@Column(name = "language_name",unique = true,nullable = false)
	private String languageName;
	
	@OneToMany(mappedBy = "language",fetch = FetchType.LAZY)
	private List<SubTechnology> subTechnologies;

}
