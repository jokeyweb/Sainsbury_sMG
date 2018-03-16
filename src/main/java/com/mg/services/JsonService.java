package com.mg.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mg.products.Products;

public class JsonService {
    //the function is converting an object Products to a JSON string
    public String convertProductsToJson(Products products){				
	ObjectMapper mapper = new ObjectMapper();
        String result = "";
        
        try {
            result = mapper.writeValueAsString(products);
        } catch (JsonProcessingException ex) {
            //TODO
        }

        return result;
    }
}
