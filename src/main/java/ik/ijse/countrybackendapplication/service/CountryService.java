package ik.ijse.countrybackendapplication.service;

import ik.ijse.countrybackendapplication.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    List<Country> searchCountries(String query);
}
