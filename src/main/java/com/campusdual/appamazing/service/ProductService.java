package com.campusdual.appamazing.service;

import com.campusdual.appamazing.api.IProductsService;
import com.campusdual.appamazing.model.Product;
import com.campusdual.appamazing.model.dao.ProductDAO;
import com.campusdual.appamazing.model.dto.ProductDTO;
import com.campusdual.appamazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
@Lazy // Evita que se cargue al iniciar la aplicación. Se cargará la primera vez que se invoque
public class ProductService implements IProductsService {
    @Autowired // Se asigna automáticamente la instancia para que pueda trabajar
    private ProductDAO productDAO;
    @Override
    public ProductDTO queryProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        return ProductMapper.INSTANCE.toDTO(productDAO.getReferenceById(product.getId()));
    }

    @Override
    public List<ProductDTO> queryAllProducts() {
        return ProductMapper.INSTANCE.toDTOList(productDAO.findAll());
    }

    @Override
    public int insertProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        productDAO.saveAndFlush(product);
        return product.getId();
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {
        // Si existe lo actualiza, sino crea uno nuevo
        return this.insertProduct(productDTO);
    }

    @Override
    public int deleteProduct(ProductDTO productDTO) {
        int id = productDTO.getId();
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        productDAO.delete(product);
        return id;
    }
}
