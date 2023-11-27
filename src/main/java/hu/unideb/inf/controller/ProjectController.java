package hu.unideb.inf.controller;

import hu.unideb.inf.dto.ProducerDTO;
import hu.unideb.inf.dto.ProductDTO;
import hu.unideb.inf.model.Product;
import hu.unideb.inf.service.ProducerService;
import hu.unideb.inf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/src")
public class ProjectController {
    @Autowired
    ProductService productService;
    /*ArrayList<Product> products;*/
    @Autowired
    ProducerService producerService;

    @GetMapping("/init")
    public String init(){
        /*products = new ArrayList<>();*/

        producerService.saveProducer(new ProducerDTO(1, "Lucky Goldstar", "lg.com"));
        producerService.saveProducer(new ProducerDTO(2, "Mr. Clean Co.", "mrclean.com"));
        producerService.saveProducer(new ProducerDTO(3, "Balogh and Son's", "bnsons.com"));

        productService.saveProduct(new ProductDTO(1, "Telephone", "Electronic", 251));
        productService.saveProduct(new ProductDTO(2, "Bread", "Food", 10));
        productService.saveProduct(new ProductDTO(3, "Window cleaner", "Cleaning Product", 3));
        productService.saveProduct(new ProductDTO(4, "Orange", "Fruit", 15));

        return "success";
    }
    @GetMapping("/")
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
    @GetMapping("/deletepoductbyid")
    public ResponseEntity<List<ProductDTO>> deleteProductById(@RequestParam int id){
        productService.doDeleteProduct(id);
        return new ResponseEntity<List<ProductDTO>>(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/renameproduct")
    public ResponseEntity<List<ProductDTO>> renameProduct(@RequestParam int id, @RequestParam String name){
        productService.editNameById(id, name);
        return new ResponseEntity<List<ProductDTO>>(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/getallproducer")
    public ResponseEntity<List<ProducerDTO>> getAllProducer(){
        return new ResponseEntity<List<ProducerDTO>>(producerService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/createproduct")
    public ResponseEntity<List<ProductDTO>> createProduct(@RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return new ResponseEntity<List<ProductDTO>>(productService.findAll(), HttpStatus.CREATED);
    }
}
