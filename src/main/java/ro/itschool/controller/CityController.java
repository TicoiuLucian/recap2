package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.entity.City;
import ro.itschool.exception.CityNotFoundException;
import ro.itschool.service.CityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/name/{cityName}")
    public ResponseEntity<City> findByName(@PathVariable String cityName) throws CityNotFoundException {
        return new ResponseEntity<>(cityService.findByName(cityName), HttpStatus.OK);
    }

    @GetMapping("/country-name/{countryName}")
    public ResponseEntity<Page<City>> findCitiesByCountryName(
            @PathVariable String countryName,
            final Pageable pageable) {
        return new ResponseEntity<>(cityService.findByCountryName(countryName, pageable), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<City>> getAllCities(Pageable pageable) {
        return new ResponseEntity<>(cityService.findAll(pageable), HttpStatus.OK);
    }

}
