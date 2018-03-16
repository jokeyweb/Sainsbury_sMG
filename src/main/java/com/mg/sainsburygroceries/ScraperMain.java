package com.mg.sainsburygroceries;

import com.mg.pages.ProductList;
import com.mg.services.JsonService;
import java.io.IOException;
import java.net.URISyntaxException;

public class ScraperMain {
    private static String url = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
    private static JsonService jsonService = new JsonService();
    private static ProductList pl;
    
    public static void main(String[] args){
        String result = "";
        //Get product html page
        try {
            pl = new ProductList(url);
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Error: Page not available");
        }
        
        //create products object and convert object in Json
        result = jsonService.convertProductsToJson(pl.getProducts());
        System.out.println(result);
    }

    public ScraperMain() {
    }
    
}
