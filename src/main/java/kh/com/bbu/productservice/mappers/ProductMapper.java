package kh.com.bbu.productservice.mappers;

import java.util.Objects;
import kh.com.bbu.productservice.dto.request.ProductRequest;
import kh.com.bbu.productservice.dto.response.ProductResponse;
import kh.com.bbu.productservice.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity toEntity(ProductRequest request){
        return ProductEntity.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .price(request.getPrice())
            .discount(request.getDiscount())
            .build();
    }

    public ProductResponse toResponse(ProductEntity request){
        return ProductResponse.builder()
            .id(request.getId())
            .title(request.getTitle())
            .description(request.getDescription())
            .price(request.getPrice())
            .discount(request.getDiscount())
            .createdDate("")
            .category(Objects.isNull(request.getCategory()) ? null : request.getCategory())
            .build();
    }

}
