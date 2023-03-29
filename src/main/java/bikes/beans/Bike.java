/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package bikes.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Bike {
	@Id
	@GeneratedValue
	private long id;
	private String bikeModel;
	private String bikeSpecialty;
	private double bikePrice;
	
	public Bike(String bikeModel, String bikeSpecialty, double bikePrice) {
		this.bikeModel = bikeModel;
		this.bikeSpecialty = bikeSpecialty;
		this.bikePrice = bikePrice;
	}

}
