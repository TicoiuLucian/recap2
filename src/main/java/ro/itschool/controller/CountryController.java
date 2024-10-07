package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Country;
import ro.itschool.exception.CountryNotFoundException;
import ro.itschool.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/name/{countryName}")
    public ResponseEntity<Country> getCountryByName(
            @PathVariable String countryName,
            @RequestParam boolean includeCities) throws CountryNotFoundException {
        return new ResponseEntity<>(countryService.findByName(countryName, includeCities), HttpStatus.OK);
    }

    //http://localhost:8080/country/all?page=1&size=5&sort=name,desc
    @GetMapping("/all")
    public ResponseEntity<Page<Country>> getAllCountries(Pageable pageable) {
        return new ResponseEntity<>(countryService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/currency/{currency}")
    public ResponseEntity<Page<Country>> findByCurrency(Pageable pageable, @PathVariable String currency) {
        return new ResponseEntity<>(countryService.findByCurrency(pageable, currency), HttpStatus.OK );
    }
    @GetMapping("/2024")
    public ResponseEntity<Page<Country>> findUpdatedIn2024(Pageable pageable){
        return new ResponseEntity<>(countryService.findUpdatedin2024(pageable), HttpStatus.OK);
    }
}
