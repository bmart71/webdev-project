package hu.unideb.inf.service;

import hu.unideb.inf.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Integer id);
    ProductDTO saveProduct(ProductDTO productDTO);
    void doDeleteProduct(Integer id);
}
