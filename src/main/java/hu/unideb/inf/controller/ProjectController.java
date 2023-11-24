package hu.unideb.inf.controller;

import hu.unideb.inf.model.Product;
import hu.unideb.inf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/src")
public class ProjectController {
    @Autowired
    ProductService productService;
    ArrayList<Product> products;

    @GetMapping("/init")
    public String init(){
        products = new ArrayList<>();

        products.add(new Product(1, "Telephone", "Electronic", 251));
        products.add(new Product(2, "Bread", "Food", 10));
        products.add(new Product(3, "Window cleaner", "Cleaning Product", 3));
        products.add(new Product(4, "Orange", "Fruit", 15));

        return "success";
    }
    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    @GetMapping("/getproductbyid")
    public ResponseEntity<Product> getProductById(@RequestParam int id){
        Product product = products.stream()
                .filter(x -> x.getId() == id)
                .findAny().get();

        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }
}
