package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.itschool.entity.City;
import ro.itschool.exception.CityNotFoundException;
import ro.itschool.repository.CityRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

}