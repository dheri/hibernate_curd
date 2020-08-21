/**
 * 
 */
package in.parteek.beans;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable

/**
 * Created on : 2019-01-22, 4:52:21 p.m.
 *
 * @author Parteek Dheri
 */
public class Toy {
	String type;
	int weight;
	String color;

}
