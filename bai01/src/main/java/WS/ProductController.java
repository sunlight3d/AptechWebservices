package WS;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class ProductController {

    @RequestMapping(method=GET,name="/product")
    public Product product(@RequestParam(value="name", defaultValue="World") String name) {
        Product newProduct = new Product(1,
                "iphone X", 100.0,"This is iphone X");
        return newProduct;
    }

    @GetMapping("/products")
    List<Product> all(String orderBy) {
        System.out.println("Orderby = "+orderBy);
        Product newProduct1 = new Product(1,
                "iphone X", 100.0,"This is iphone X");
        Product newProduct2 = new Product(2,
                "iphone 6", 200.0,"This is iphone 6");
        Product newProduct3 = new Product(3,
                "iphone 7", 311.2,"This is iphone 7");
        List newProducts = new ArrayList<Product>();
        newProducts.add(newProduct1);
        newProducts.add(newProduct2);
        newProducts.add(newProduct3);
        return newProducts;
    }

}
