/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mg.pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matteo
 */
public class GetPageTest {
    private final String urlTest = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
    private final String urlTest2 = "https://www.google.co.uk";
    private GetPage t;
    
    @Before
    public void setUp() throws IOException, URISyntaxException {
        t = new GetPage(urlTest);
    }

    @Test
    public void testGetHtmlDocument() throws IOException {
        assertThat( getHtmlPage().select("head").toString(), equalTo(t.getHtmlDocument().select("head").toString()));
    }

    @Test
    public void testSetUrl() throws IOException, MalformedURLException, URISyntaxException {
        t.setUrl(urlTest2);
        assertFalse( getHtmlPage().select("head").toString().equals(t.getHtmlDocument().select("head").toString()) );
        t.setUrl(urlTest);
        assertTrue( getHtmlPage().select("head").toString().equals(t.getHtmlDocument().select("head").toString()) );
    }

    @Test
    public void testGetElements() throws IOException {
        List<String> test = Arrays.asList("div.productInfo","div.productNameAndPromotions", "a");
        String expectedResult = getHtmlPage().select("div.productInfo div.productNameAndPromotions a").toString();
        
        assertThat(t.getElements(t.getHtmlDocument(), test).toString(), equalTo(expectedResult));
    }

    @Test
    public void testGetFirstStringFromElement() throws IOException {
        List<String> test = Arrays.asList("div.productInfo","div.productNameAndPromotions", "a");
        String expectedResult = Parser.unescapeEntities(getHtmlPage().select("div.productInfo div.productNameAndPromotions a").first().text(), true);
        
        assertThat(t.getFirstStringFromElement(t.getHtmlDocument(), test), equalTo(expectedResult));
    }

    @Test
    public void testGetFirstHtmlFromElement() throws IOException {
        List<String> test = Arrays.asList("div.productInfo","div.productNameAndPromotions", "a");
        String expectedResult = getHtmlPage().select("div.productInfo div.productNameAndPromotions a").first().html();
        
        assertThat(t.getFirstHtmlFromElement(t.getHtmlDocument(), test), equalTo(expectedResult));
    }

    @Test
    public void testGetFirstURLFromElement() throws IOException {
        List<String> test = Arrays.asList("div.productInfo","div.productNameAndPromotions", "a");
        String expectedResult = getHtmlPage().select("div.productInfo div.productNameAndPromotions a").first().attr("abs:href");
        
        assertThat(t.getFirstURLFromElement(t.getHtmlDocument(), test), equalTo(expectedResult)); 
    }
    
    private Document getHtmlPage() throws IOException{
        File input = new File(getClass().getClassLoader().getResource("Sainsbury_s-test.htm").getFile());
        Document doc = Jsoup.parse(input, "UTF-8", urlTest);
	return doc;
    }
}
