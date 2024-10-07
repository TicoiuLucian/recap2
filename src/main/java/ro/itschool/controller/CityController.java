package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.entity.City;
import ro.itschool.entity.Country;
import ro.itschool.service.CityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;


    @GetMapping("/all")
    public ResponseEntity<Page<City>> getAllCountries(Pageable pageable) {
        return new ResponseEntity<>(cityService.findAll(pageable), HttpStatus.OK);
    }
}