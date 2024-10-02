package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Country;
import ro.itschool.exception.CountryNotFoundException;
import ro.itschool.repository.CountryRepository;

@Service
@RequiredArgsConstructor
public class CountryService {

  private final CountryRepository countryRepository;

  public Country findByName(
          final String countryName,
          final boolean includeCities) throws CountryNotFoundException {
    if (includeCities) {
      return countryRepository.findByName(countryName)
              .orElseThrow(() -> new CountryNotFoundException("Country " + countryName + " not found"));
    }
    return countryRepository.findByNameWithoutCities(countryName)
            .orElseThrow(() -> new CountryNotFoundException("Country " + countryName + " not found"));
  }

  public Page<Country> findAll(final int page, final int size, final String property, final Sort.Direction direction) {
    Sort sort = direction == Sort.Direction.ASC ?
            Sort.by(property).ascending() : Sort.by(property).descending();

    Pageable pageable = PageRequest.of(page, size, sort);
    return countryRepository.findAll(pageable);
  }
}
