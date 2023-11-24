package hu.unideb.inf.service;

import hu.unideb.inf.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
}
