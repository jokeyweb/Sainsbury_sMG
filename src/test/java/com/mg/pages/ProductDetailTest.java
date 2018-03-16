/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.pages;

import java.io.IOException;
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
public class ProductDetailTest {
    private final String urlTest = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/shop/gb/groceries/berries-cherries-currants/sainsburys-british-strawberries-400g.html";
    private ProductDetail t;
    
    @Before
    public void setUp() throws IOException, MalformedURLException, URISyntaxException {
        t = new ProductDetail(urlTest);
    }

    @Test
    public void testGetDescription() {
        assertThat(t.getDescription(), equalTo("by Sainsbury's strawberries"));
        
    }

    @Test
    public void testGetKcalPer100g() {
        assertThat(t.getKcalPer100g(), equalTo(33));
    }
    
}
