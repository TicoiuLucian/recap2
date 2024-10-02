package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
