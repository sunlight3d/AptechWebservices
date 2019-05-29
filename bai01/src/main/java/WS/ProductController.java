package WS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FilterAndSortingProductRepository filterAndSortingProductRepository;

    @RequestMapping(method=GET,name="/product")
    public Product product(@RequestParam(value="name", defaultValue="World") String name) {
        Product newProduct = new Product();
        return newProduct;
    }

    @GetMapping("/filter_products")
    Hashtable<String, Object> filterProducts(String stringContain) {
        System.out.println("stringContain = "+stringContain);
        Hashtable hastableResult = new Hashtable();
        Iterable<Product> allProducts = productRepository.findAll();
        List<Product> filteredProducts = StreamSupport
                .stream(allProducts.spliterator(), false)
                .filter(p->{
                    return p.getProductName().contains(stringContain);
                })
                .collect(Collectors.toList());
        hastableResult.put("result", "ok");
        hastableResult.put("data", filteredProducts);
        hastableResult.put("message", "Query products successfully");

        return hastableResult;
    }
    @GetMapping("/paging_products")
    Hashtable<String, Object> pagingProducts(Integer page, Integer size) {
        Hashtable hastableResult = new Hashtable();
        Pageable paging = PageRequest.of(page, size);
        Page<Product> filteredProducts = filterAndSortingProductRepository.findAll(paging);
        hastableResult.put("result", "ok");
        hastableResult.put("data", filteredProducts);
        hastableResult.put("message", "Query products successfully");

        return hastableResult;
    }
    @DeleteMapping("/delete_product")
    Hashtable<String, Object> deleteProduct(Long productId) {
        Hashtable hastableResult = new Hashtable();
//        productRepository.deleteById(productId);
        Iterable<Product> allProducts = productRepository.findAll();
        List<Product> filteredProducts = StreamSupport
                .stream(allProducts.spliterator(), false)
                .filter(p->{
                    return p.getProductId().equals(productId);
                })
                .collect(Collectors.toList());

        for(Product product: filteredProducts) {
            productRepository.delete(product);
        }
        hastableResult.put("result", "ok");
        hastableResult.put("data", "");
        hastableResult.put("message", "Delete product successfully");

        return hastableResult;
    }

    @PostMapping(path="/products")
    public @ResponseBody Hashtable<String, Object> add(String productName,
                                     Double price,
                                     String description) {
        System.out.println("name  = "+productName);
        Product newProduct = new Product();
        Date date= new Date();
        Long currentTimestamp = (long) date.getTime();
        newProduct.setProductId(currentTimestamp);
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

}
