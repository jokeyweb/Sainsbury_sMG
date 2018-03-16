package com.mg.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;

@JsonPropertyOrder({
"title",
"kcal_per_100g",
"unit_price",
"description"
})
public class Product {

@JsonProperty("title")
private String title;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonProperty("kcal_per_100g")
private Integer kcalPer100g;
@JsonProperty("unit_price")
private BigDecimal unitPrice;
@JsonProperty("description")
private String description;

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("kcal_per_100g")
public Integer getKcalPer100g() {
return kcalPer100g;
}

@JsonProperty("kcal_per_100g")
public void setKcalPer100g(Integer kcalPer100g) {
this.kcalPer100g = kcalPer100g;
}

@JsonProperty("unit_price")
public BigDecimal getUnitPrice() {
    return unitPrice;
}

@JsonProperty("unit_price")
public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice.setScale(2);
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

}