package hu.unideb.inf.controller;

import hu.unideb.inf.dto.ProductDTO;
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
import java.util.List;

@RestController
@RequestMapping("/src")
public class ProjectController {
    @Autowired
    ProductService productService;
    ArrayList<Product> products;

    @GetMapping("/init")
    public String init(){
        /*products = new ArrayList<>();*/

        productService.saveProduct(new ProductDTO(1, "Telephone", "Electronic", 251));
        productService.saveProduct(new ProductDTO(2, "Bread", "Food", 10));
        productService.saveProduct(new ProductDTO(3, "Window cleaner", "Cleaning Product", 3));
        productService.saveProduct(new ProductDTO(4, "Orange", "Fruit", 15));

        return "success";
    }
    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    @GetMapping("/getproductbyid")
    public ResponseEntity<ProductDTO> getProductById(@RequestParam int id){
        return new ResponseEntity<ProductDTO>(productService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/getallproduct")
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        return new ResponseEntity<List<ProductDTO>>(productService.findAll(), HttpStatus.OK);
    }
}
