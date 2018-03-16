package com.mg.pages;

import com.mg.products.Products;
import com.mg.products.Product;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductList extends GetPage{
    private String selectProducts = "div.product";
    private String selectProductTitle = "div.productInfo div.productNameAndPromotions a";
    private String selectPricePerUnit = "p.pricePerUnit";
    private String selectProductUrl = "div.productInfo div.productNameAndPromotions a";
    
    public ProductList(String url) throws IOException, MalformedURLException, URISyntaxException {
        super(url);
    }
    
    public Products getProducts(){
        Products result = new Products();
        Elements productsList = getElements(getHtmlDocument(), Arrays.asList(selectProducts));
        
        List<Product> products = new ArrayList<>();
            for (Element product : productsList) {			
		Product p = getProduct(product);
		products.add(p);
	}
        result.setResults(products);
        return result;
    }
    
    //get product info and create new product
    private Product getProduct(Element product) {
	Product p = new Product();
        String tmp = "";
        

	p.setTitle(getTitle(product));//set title
	p.setUnitPrice(getUnitPrice(product));//set Unit Price
        
        //get detail page url
        tmp = getFirstURLFromElement(product, Arrays.asList(selectProductUrl));
	ProductDetail productDt;
        try {
            productDt = new ProductDetail(tmp);//throws errors in case the page is not reacheable. Error can be handled in order to export first part of the product detail
            
            p.setDescription(productDt.getDescription());
            p.setKcalPer100g(productDt.getKcalPer100g());
        } catch ( IOException | URISyntaxException ex){
            //TODO no details were able to be recovered
        }
	return p;
    }
    
    private String getTitle(Element product){
        String tmp = "";
        tmp = getFirstStringFromElement(product, Arrays.asList(selectProductTitle));
        return tmp;
    }
    
    private BigDecimal getUnitPrice(Element product){
        String tmp = "";
        tmp = getFirstStringFromElement(product, Arrays.asList(selectPricePerUnit));
        tmp = tmp.substring(0, tmp.indexOf("/"));//removing "/unit" from result
        tmp = tmp.replaceAll("[^0-9.]", "");//remove non numerical characters
        return new BigDecimal(tmp);
    }
}
