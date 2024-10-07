package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.itschool.entity.City;
import ro.itschool.exception.CityNotFoundException;
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

    public List<City> findCitiesByCountryName(final String countryName) throws CityNotFoundException {
        List<City> cities = cityRepository.findCitiesByCountryName(countryName);
        if (cities.isEmpty()) {
            throw new CityNotFoundException("No cities found for country " + countryName);
        }
        return cities;
    }

    public Page<City> findAll(final Pageable pageable) {
        return cityRepository.findAll(pageable);
    }
}