package com.campusdual.appamazing.model.dto.dtomapper;

import com.campusdual.appamazing.model.Product;
import com.campusdual.appamazing.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTOList(List<Product> products);
    Product toEntity(ProductDTO productDTO);
}
