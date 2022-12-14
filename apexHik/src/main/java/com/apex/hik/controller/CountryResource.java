package com.apex.hik.controller;

import com.apex.hik.model.Countries;
import com.apex.hik.model.Country;
import com.apex.hik.model.EmployeeAddresses;
import com.apex.hik.model.EmployeeNames;
import com.apex.hik.response.Response;
import com.apex.hik.service.CountryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@RestController
@RequestMapping("api/thread/")
@RequiredArgsConstructor
public class CountryResource {

    private final CountryClient countryClient;

@GetMapping("/getData")
public Countries getAllEuropeanFrenchSpeakingCountries() throws InterruptedException, ExecutionException {
    System.out.println("Test Thread");
    CompletableFuture<List<Country>> countriesByLanguageFuture = countryClient.getCountriesByLanguage("fr");
    CompletableFuture<List<Country>> countriesByRegionFuture = countryClient.getCountriesByRegion("europe");

    CompletableFuture.allOf(countriesByLanguageFuture, countriesByRegionFuture).join();
    System.out.println("Country By Language: " + countriesByLanguageFuture.get());
    System.out.println("Country By Region: " + countriesByRegionFuture.get());

    Countries countryList = new Countries();
    countryList.setCountryByLanguage(countriesByLanguageFuture.get());
    countryList.setCountryByRegion(countriesByRegionFuture.get());
    return countryList;
}

    @GetMapping("/empData")
    public void testAsynch() throws InterruptedException, ExecutionException
    {
        System.out.println("testAsynch Start");

        CompletableFuture<EmployeeAddresses> employeeAddress = countryClient.getEmployeeAddress();
        CompletableFuture<EmployeeNames> employeeName = countryClient.getEmployeeName();


        // Wait until they are all done
        CompletableFuture.allOf(employeeAddress, employeeName).join();

        System.out.println("EmployeeAddress--> " + employeeAddress.get());
        System.out.println("EmployeeName--> " + employeeName.get());

    }
}
