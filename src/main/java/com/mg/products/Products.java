package com.mg.products;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;

@JsonPropertyOrder({
"results",
"total"
})
public class Products {

@JsonProperty("results")
private List<Product> results = null;
@JsonProperty("total")
private BigDecimal total;

@JsonProperty("results")
public List<Product> getResults() {
return results;
}

@JsonProperty("results")
public void setResults(List<Product> results) {
this.results = results;
}

@JsonProperty("total")
public BigDecimal getTotal() {
    this.total = new BigDecimal(0);
    
    if(results.size()>0){
        for (Product g : results) {
            total = total.add(g.getUnitPrice());
	}
    }

    return total.setScale(2);
}

}