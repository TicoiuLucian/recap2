package ro.itschool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String cityName);

    Page<City> findByCountryName(String countryName, Pageable pageable);


    List<City> findByCountryCode(String countryCode);

}
