package WS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method=GET,name="/product")
    public Product product(@RequestParam(value="name", defaultValue="World") String name) {
        Product newProduct = new Product();
        return newProduct;
    }

    @GetMapping("/products")
    Hashtable<String, Object> all(String orderBy) {
        System.out.println("Orderby = "+orderBy);
        Hashtable hastableResult = new Hashtable();
        hastableResult.put("result", "ok");
//        hastableResult.put("data", newProducts);
        hastableResult.put("message", "Query products successfully");
        Iterable<Product> products = productRepository.findAll();

        return hastableResult;
    }
    @PostMapping(path="/products")
    public @ResponseBody Hashtable<String, Object> add(String productName,
                                     Double price,
                                     String description) {
        System.out.println("name  = "+productName);
        Product newProduct = new Product();
        newProduct.setProductId(123);
        newProduct.setProductName(productName);
        newProduct.setPrice(price);
        newProduct.setDescription(description);
        productRepository.save(newProduct);

        Hashtable hastableResult = new Hashtable();
        hastableResult.put("result", "ok");
        hastableResult.put("data", newProduct);
        hastableResult.put("message", "Insert new product successfully");
        return hastableResult;
    }
    @PutMapping(path="/products")
    public @ResponseBody Hashtable<String, Object> update(Integer productId,
                                                        String productName,
                                                       Double price,
                                                       String description) {
        System.out.println("productId  = "+productId);
        Hashtable hastableResult = new Hashtable();
        hastableResult.put("result", "ok");
        //hastableResult.put("data", newProduct);
        hastableResult.put("message", "Update new product successfully");
        return hastableResult;
    }
    @DeleteMapping(path="/products")
    public @ResponseBody Hashtable<String, Object> delete(Integer productId) {
        System.out.println("productId  = "+productId);
        Hashtable hastableResult = new Hashtable();
        hastableResult.put("result", "ok");
        hastableResult.put("message", "Delete new product successfully");
        return hastableResult;
    }

}
