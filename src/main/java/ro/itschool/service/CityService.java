package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.itschool.entity.City;
import ro.itschool.entity.Country;
import ro.itschool.exception.CityNotFoundException;
import ro.itschool.exception.CountryNotFoundException;
import ro.itschool.repository.CityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public City findByName(final String cityName) throws CityNotFoundException {
        return cityRepository.findByName(cityName)
                .orElseThrow(() -> new CityNotFoundException("City " + cityName + " not found"));
    }

    public City update(City city) {
        if (city.getId() == null) {
            throw new RuntimeException("id cannot be null");
        }
        try {
            return cityRepository.save(city);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("city must not be null");
        }
    }
  public Page<City> findAll(final Pageable pageable) {
    return cityRepository.findAll(pageable);
  }

  public Page<City> findByCountryName(final String countryname, final Pageable pageable) {
    return cityRepository.findByCountryName(countryname, pageable);
  }


}




