package hu.unideb.inf.service.impl;

import hu.unideb.inf.dto.ProductDTO;
import hu.unideb.inf.model.Product;
import hu.unideb.inf.repository.ProductRepository;
import hu.unideb.inf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product p : products){
            productDTOS.add(new ProductDTO(p.getId(), p.getName(), p.getType(), p.getAmountAvailable()));
        }

        return productDTOS;
    }

    @Override
    public ProductDTO findById(Integer id) {
        Product e = productRepository.getReferenceById(id);
        return new ProductDTO(e.getId(), e.getName(), e.getType(), e.getAmountAvailable());
    }

    @Override
    public ProductDTO saveProduct(ProductDTO pDTO){
        Product e = new Product(pDTO.getId(), pDTO.getName(), pDTO.getType(), pDTO.getAmountAvailable());
        e = productRepository.save(e);

        return new ProductDTO(e.getId(),e.getName(),e.getType(),e.getAmountAvailable());
    }

    @Override
    public void doDeleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
