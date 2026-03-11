package ik.ijse.countrybackendapplication.controller;

import ik.ijse.countrybackendapplication.model.Country;
import ik.ijse.countrybackendapplication.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/search")
    public List<Country> searchCountries(@RequestParam String q) {
        return countryService.searchCountries(q);
    }
}