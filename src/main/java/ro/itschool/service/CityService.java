package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.itschool.entity.City;
import ro.itschool.entity.Country;
import ro.itschool.exception.CityNotFoundException;
import ro.itschool.exception.CountryNotFoundException;
import ro.itschool.repository.CityRepository;
import ro.itschool.repository.CountryRepository;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public City findByName(final String cityName) throws CityNotFoundException {
            return cityRepository.findByName(cityName)
                    .orElseThrow(()-> new CityNotFoundException("City" + cityName + " not found"));
        }



//    public City findByName (final String cityName){
//        return cityRepository.findByName(cityName).orElseThrow(()-> new CityNotFoundException("City" + cityName + " not found"));
//    }
//    public Page<City> findAll(final Pageable pageable){
//        return cityRepository.findAll(pageable);
//
//    }

    public Page<City> findAll(final Pageable pageable) {
        return cityRepository.findAll(pageable);
      }
    }

