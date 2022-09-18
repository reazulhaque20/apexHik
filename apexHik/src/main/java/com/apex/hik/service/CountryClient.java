package com.apex.hik.service;

import com.apex.hik.model.Countries;
import com.apex.hik.model.Country;
import com.apex.hik.model.EmployeeAddresses;
import com.apex.hik.model.EmployeeNames;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CountryClient {
    RestTemplate restTemplate = new RestTemplate();

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Async("asyncExecutor")
    public CompletableFuture<List<Country>> getCountriesByLanguage(String language) throws InterruptedException {
        String url = "https://restcountries.com/v2/lang/" + language + "?fields=name";
//      ResponseEntity<Country[]> response = restTemplate.getForEntity(url, Country[].class);
//      Country[] countryArray = response.getBody();
//      System.out.println("Country Array: " + countryArray);
        ResponseEntity<List<Country>> responseEntity =
            restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Country>>() {}
            );
        List<Country> countryList = responseEntity.getBody();

        Thread.sleep(1000L);  //Intentional delay
        return CompletableFuture.completedFuture(countryList);
    }
    @Async("asyncExecutor")
    public CompletableFuture<List<Country>> getCountriesByRegion(String region) throws InterruptedException {
        String url = "https://restcountries.com/v2/region/" + region + "?fields=name";
//        ResponseEntity<Country[]> response = restTemplate.getForEntity(url, Country[].class);
//        Country[] countryArray = response.getBody();
//        System.out.println("Country Array: " + countryArray);
        ResponseEntity<List<Country>> responseEntity =
            restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Country>>() {}
            );
        List<Country> countryList = responseEntity.getBody();
        Thread.sleep(1000L);  //Intentional delay
        return CompletableFuture.completedFuture(countryList);
    }
    @Async("asyncExecutor")
    public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException
    {
        System.out.println("getEmployeeName Starts");
        EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8080/names", EmployeeNames.class);

        System.out.println("employeeNameData, {}"+ employeeNameData);
        Thread.sleep(1000L);	//Intentional delay
        System.out.println("employeeNameData completed");
        return CompletableFuture.completedFuture(employeeNameData);
    }
    @Async("asyncExecutor")
    public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException
    {
        System.out.println("getEmployeeAddress Starts");
        EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8080/addresses", EmployeeAddresses.class);

        System.out.println("employeeAddressData, {}"+ employeeAddressData);
        Thread.sleep(1000L);	//Intentional delay
        System.out.println("employeeAddressData completed");
        return CompletableFuture.completedFuture(employeeAddressData);
    }
}