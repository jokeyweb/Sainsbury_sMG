/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.pages;

import com.mg.products.Product;
import com.mg.products.Products;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matteo
 */
public class ProductListTest {
    private final String urlTest = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
    private ProductList t;
    
    @Before
    public void setUp() throws IOException, MalformedURLException, URISyntaxException {
        t = new ProductList(urlTest);
    }

    @Test
    public void testGetProducts() {
        Product p = t.getProducts().getResults().get(0);//get test product
        
        assertThat(p.getTitle(), equalTo("Sainsbury's Strawberries 400g"));
        assertThat(p.getDescription(), equalTo("by Sainsbury's strawberries"));
        assertThat(p.getUnitPrice(), equalTo(new BigDecimal(1.75)));
        assertThat(p.getKcalPer100g(), equalTo(33));
    }
    
}
