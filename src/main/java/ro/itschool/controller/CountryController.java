package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

  @GetMapping("/all")
  public ResponseEntity<Page<Country>> getAllCountries(
          @RequestParam Integer page,
          @RequestParam Integer size,
          @RequestParam String property,
          @RequestParam Sort.Direction direction) {
    return new ResponseEntity<>(countryService.findAll(page, size, property, direction), HttpStatus.OK);
  }
}
