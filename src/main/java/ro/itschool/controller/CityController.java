package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.City;
import ro.itschool.exception.CityNotFoundException;
import ro.itschool.exception.CountryNotFoundException;
import ro.itschool.service.CityService;
import ro.itschool.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/name/{cityName}")
    public ResponseEntity<City>findCitiesByCountryName(@PathVariable String cityName) throws CityNotFoundException {
        return new ResponseEntity<>(cityService.findByName(cityName), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<City>> getAllCities(Pageable pageable) {
        return new ResponseEntity<>(cityService.findAll(pageable), HttpStatus.OK);
    }

}
