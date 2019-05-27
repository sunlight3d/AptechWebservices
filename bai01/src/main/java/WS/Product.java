package WS;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
/**
 CREATE TABLE tblProducts(
 productId INTEGER AUTO_INCREMENT PRIMARY KEY,
 productName NVARCHAR(500),
 price FLOAT DEFAULT 0.0,
 description NVARCHAR(500)
 );
 //Auto create tbl_products. NO NEED to create before !
 create user 'hoang'@'%' identified by '123456';
 grant all on wstutorials.* to 'hoang'@'%' with grant option;
 */

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productId;

    private String productName;
    private String description;
    private Double price;


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

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
