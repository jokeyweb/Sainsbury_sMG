package com.mg.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Arrays;
import org.jsoup.nodes.Element;

public class ProductDetail extends GetPage{
    private String selectDetail = "div.productText p";
    private String selectKcal = "table.nutritionTable tbody tr td.nutritionLevel1";
    
    public ProductDetail(String url) throws IOException, MalformedURLException, URISyntaxException{
        super(url);
    }
    
    public String getDescription(){
        String result;
        
        result = getFirstStringFromElement(getHtmlDocument(), Arrays.asList(selectDetail));
        
        return result;
    }
    
    public Integer getKcalPer100g(){
        Integer result;
        Element tmp;
        
        tmp = getElements(getHtmlDocument(), Arrays.asList(selectKcal)).first();
        if (tmp == null)
            result = null;
        else{
            result = new Integer(tmp.text().replaceAll("[^0-9.]", ""));
        }
        return result;
    }
    
}
