package com.apex.hik.response;

import com.apex.hik.model.Country;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Response {
    private List<Country> countryByLanguage = new ArrayList<>();
    private List<Country> countryByRegion = new ArrayList<>();

}
