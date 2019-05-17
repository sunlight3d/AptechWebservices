package WS;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity

public class Product {
    private final Integer productId;
    private final String productName;
    private final String description;
    private final Double price;

//    Product() {}
    public Product(Integer productId,
                   String productName,
                   Double price,
                   String description) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


}
