package ro.itschool.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ro.itschool.entity.City;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

  Optional<City> findByName(final String cityName);

  @Query(value = """ 
          SELECT NEW City(c.id,
          c.name,
          c.country,
          c.countryCode,
          c.latitude,
          c.longitude,
          c.createdAt,
          c.updatedAt
          ) FROM City c""")
  Page<City> findAll(final Pageable pageable);
}
