/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package bikes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bikes.beans.Bike;

@Configuration
public class BikeBeanConfig {
	
	@Bean
	public Bike bike() {
		Bike bike = new Bike();
		//bike.setBikeModel("Trek");
		//bike.setBikeSpecialty("Road");
		//bike.setBikePrice(999.99);
		return bike;
	}

}
