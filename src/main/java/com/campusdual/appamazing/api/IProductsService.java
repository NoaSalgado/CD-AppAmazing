package com.campusdual.appamazing.api;

import com.campusdual.appamazing.model.dto.ProductDTO;

import java.util.List;

public interface IProductsService {
    ProductDTO queryProduct(ProductDTO productDTO);
    List<ProductDTO> queryAllProducts();
    int insertProduct(ProductDTO productDTO);
    int updateProduct(ProductDTO productDTO);
    int deleteProduct(ProductDTO productDTO);
    /*
    @Query(value = "SELECT * FROM PRODUCTS WHERE price > :price ORDER BY price ASC;", nativeQuery = true)
    List<Product> getProductsPriceBiggerThan(BigDecimal price);
    * */
}
