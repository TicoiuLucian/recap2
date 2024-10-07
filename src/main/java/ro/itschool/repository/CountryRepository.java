package ro.itschool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findByName(final String countryName);

    @Query(value = """ 
            SELECT NEW Country(c.id,
            c.name,
            c.phonecode,
            c.capital,
            c.currency,
            c.currencyName,
            c.currencySymbol,
            c.nationality,
            c.latitude,
            c.longitude,
            c.createdAt,
            c.updatedAt
            ) FROM Country c where name =:countryName""")
    Optional<Country> findByNameWithoutCities(String countryName);

    @Query(value = """ 
            SELECT NEW Country(c.id,
            c.name,
            c.phonecode,
            c.capital,
            c.currency,
            c.currencyName,
            c.currencySymbol,
            c.nationality,
            c.latitude,
            c.longitude,
            c.createdAt,
            c.updatedAt
            ) FROM Country c""")
    Page<Country> findAllWithoutCities(final Pageable pageable);

    Page<Country> findByCurrency(final String currency, final Pageable pageable);
}
