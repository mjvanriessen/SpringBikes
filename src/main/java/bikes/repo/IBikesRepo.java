/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Mar 28, 2023
 */
package bikes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import bikes.beans.Bike;

public interface IBikesRepo extends JpaRepository<Bike, Long>{

}
