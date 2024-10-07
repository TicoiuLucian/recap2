package ro.itschool.service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.itschool.entity.City;
import ro.itschool.exception.CityNotFoundExeption;
import ro.itschool.repository.CityRepository;

@Service
@RequiredArgsConstructor
public class CityService {
  private final CityRepository cityRepository;

  public City findByName(final String cityName) throws CityNotFoundExeption {
    return cityRepository.findByName(cityName)
        .orElseThrow(() -> new CityNotFoundExeption("City " + cityName + " not found"));
  }

  public Page<City> findAll(final Pageable pageable) {
    return cityRepository.findAll(pageable);
  }

    public City getCityById(final Integer id) {
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundExeption("City with id " + id + " not found"));
    }

  public City createCity(final City city) {
    return cityRepository.save(city);
  }

  public City updateCity(final Integer id, final City city) {
    return cityRepository.findById(id)
        .map(c -> cityRepository.save(city))
        .orElseThrow(() -> new CityNotFoundExeption("City with id " + id + " not found"));
  }

}
