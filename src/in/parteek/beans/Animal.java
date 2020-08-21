/**
 * 
 */
package in.parteek.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
/**
 * Created on : 2019-01-22, 3:34:44 p.m.
 *
 * @author Parteek Dheri
 */
public class Animal implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String type;

//	@Embedded
//	private Toy toy;

	@ElementCollection
	private List<Toy> toys = new ArrayList<Toy>();

	/**
	 * @param name
	 * @param type
	 */
	public Animal(String name, String type) {
		this.name = name;
		this.type = type;
//		this.toy = new Toy();
	}

}
