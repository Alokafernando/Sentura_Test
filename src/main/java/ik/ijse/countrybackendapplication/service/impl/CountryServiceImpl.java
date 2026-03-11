package ik.ijse.countrybackendapplication.service.impl;

import ik.ijse.countrybackendapplication.model.Country;
import ik.ijse.countrybackendapplication.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private static final String API_URL = "https://restcountries.com/v2/all?fields=name,capital,region,population,flags";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    @Cacheable(value = "countries")
    public List<Country> getAllCountries() {
        Country[] countries = restTemplate.getForObject(API_URL, Country[].class);
        return Arrays.asList(countries);
    }

    @Override
    public List<Country> searchCountries(String query) {
        return getAllCountries().stream()
                .filter(c -> c.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}