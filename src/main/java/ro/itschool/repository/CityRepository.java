package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {


    Optional<City> findByName(String cityName);


    @Query("SELECT c FROM City c WHERE c.country.name = :countryName")
    List<City> findCitiesByCountryName(String countryName);


    List<City> findByCountryCode(String countryCode);
}
