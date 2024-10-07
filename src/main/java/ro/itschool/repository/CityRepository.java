package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.City;

public interface CityRepository extends JpaRepository<City,Integer> {
}
