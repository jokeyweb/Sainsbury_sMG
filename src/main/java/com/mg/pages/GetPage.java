package com.mg.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class GetPage {
    private String url;
    private Document page = null;

    public GetPage(String url) throws IOException, MalformedURLException, URISyntaxException{
        setUrl(url);
    }
    //return the loaded html page
    public Document getHtmlDocument(){
        return page;
    }
    //load and save the html page
    private void getPage(String url) throws IOException{
        this.page = Jsoup.connect(url).get();
    }
    
    public void setUrl(String url) throws IOException, MalformedURLException, URISyntaxException{
        //verify if url is valid. If not the proper exception is thrown
        URL u = new URL(url);
        u.toURI();
        
        //if url is valid, the new url is saved and he new page is loaded
        this.url = url;
        getPage(this.url);//can throw IOException
    }
    
    //given a Jsoup element and a list of strings it selects via Jsoup the wanted elements
    protected Elements getElements(Element element, List<String> select){
        Elements tmp = element.select(select.get(0));
        
        for(int i = 1; i<select.size(); i++){
            tmp = tmp.select(select.get(i));
        }
        
        return tmp;
    }
    
    //given a Jsoup element and a list of strings it selects via Jsoup the wanted element returnig the text in the html element
    protected String getFirstStringFromElement(Element element, List<String> select){
        String result = "";
        result = getElements(element, select).first().text();
        return Parser.unescapeEntities(result, true);
    }
    
    //given a Jsoup element and a list of strings it selects via Jsoup the wanted element returnig the Html in the html element
    protected String getFirstHtmlFromElement(Element element, List<String> select){
        String result = "";
        result = getElements(element, select).first().html();
        return result;
    }
    
    //given a Jsoup element and a list of strings it selects via Jsoup the wanted element returnig the URL in the html element
    protected String getFirstURLFromElement(Element element, List<String> select){
        String result = "";
        result = getElements(element, select).first().attr("abs:href");
        return result;
    }
}
