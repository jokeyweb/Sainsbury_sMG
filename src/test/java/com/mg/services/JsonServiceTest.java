/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.services;

import com.mg.products.Product;
import com.mg.products.Products;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matteo
 */
public class JsonServiceTest {
    Products pList = new Products();
    
    @Before
    public void setUp() {
        List<Product> testList = new ArrayList<Product>();
        Product p;

        //adding 3 elements to the products list
        p = new Product();
        p.setTitle("Strowberries");
        p.setDescription("testStrowberries");
        p.setKcalPer100g(10);
        p.setUnitPrice(new BigDecimal(11));
        testList.add(p);
        
        p = new Product();
        p.setTitle("Bananas");
        p.setDescription("testBananas");
        p.setKcalPer100g(5);
        p.setUnitPrice(new BigDecimal(9));
        testList.add(p);
        
        p = new Product();
        p.setTitle("Mellon");
        p.setDescription("testmellon");
        p.setKcalPer100g(500);
        p.setUnitPrice(new BigDecimal(8));
        testList.add(p);
        
        //add list to the Products object
        pList.setResults(testList);
    }

    @Test
    public void testConvertProductsToJson() throws Exception {
        JsonService jsonService = new JsonService();
        String expectedResult = "{\"results\":[{\"title\":\"Strowberries\",\"kcal_per_100g\":10,\"unit_price\":11.00,\"description\":\"testStrowberries\"},{\"title\":\"Bananas\",\"kcal_per_100g\":5,\"unit_price\":9.00,\"description\":\"testBananas\"},{\"title\":\"Mellon\",\"kcal_per_100g\":500,\"unit_price\":8.00,\"description\":\"testmellon\"}],\"total\":28.00}";
        
        assertThat( expectedResult, equalTo(jsonService.convertProductsToJson(pList)) );
    }
    
}
