package kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SubTechnologies")
@Entity
public class SubTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subTechnology_id", unique = true)
	private int subTechnologyId;
	
	@Column(name = "subTechnology_name")
	private String subTechnologyName;
	
	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Language language;

}
