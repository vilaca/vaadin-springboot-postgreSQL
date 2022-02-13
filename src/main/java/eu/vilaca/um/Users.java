package eu.vilaca.um;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Users {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
}