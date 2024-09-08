package com.example.demoRestTemplate.client;

import com.example.demoRestTemplate.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AddressClient {

    @Autowired
    private RestTemplate restTemplate;
    public void saveAddress(List<Address> addresses,Integer empId){

        addresses.stream().forEach( address -> {
            address.setEmpId(empId);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Address> httpEntity = new HttpEntity<>(address,httpHeaders);
            restTemplate.exchange("http://localhost:7070/address", HttpMethod.POST,httpEntity,String.class);
        });

    }
}
