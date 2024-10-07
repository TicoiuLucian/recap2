package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.City;
import ro.itschool.exception.CityNotFoundExeption;
import ro.itschool.service.CityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")

public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<Page<City>> getAllCities(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<City> cities = cityService.getAllCities(Pageable.of(page, size));
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id) {
        City city = cityService.getCityById(id);
        if (city == null) {
            throw new CityNotFoundExeption();
        }
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.createCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long id, @RequestBody City city) {
        City updatedCity = cityService.updateCity(Math.toIntExact(id), city);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCity);
    }
}
