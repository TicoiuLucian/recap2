package ro.itschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.itschool.entity.City;
import ro.itschool.entity.Country;
import ro.itschool.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class CountriesApplication {

  public static CountryRepository repository;

  @Autowired
  public CountriesApplication(CountryRepository repository) {
    CountriesApplication.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(CountriesApplication.class, args);
    List<Country> countries = repository.findAll();

    List<City> cities = countries.stream()
            .flatMap(country -> country.getCities().stream())
            .collect(Collectors.toList());
    cities.forEach(System.out::println);


    List<List<City>> cities2 = countries.stream()
            .map(country -> country.getCities())
            .collect(Collectors.toList());
  }

}
