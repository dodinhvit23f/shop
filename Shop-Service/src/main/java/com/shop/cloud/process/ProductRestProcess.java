package com.shop.cloud.process;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.abstracts.BaseRestController;
import com.shop.cloud.entities.Product;
import com.shop.cloud.repositories.ProductsRepository;
import com.shop.dto.ProductDTO;
import com.shop.rest.RestHeader;
import com.shop.rest.request.ProductRequest;
import com.shop.rest.response.ProductResponse;

@RestController
@RequestMapping("product")
public class ProductRestProcess extends BaseRestController<ProductRequest, ProductResponse>{
    
    @Autowired
    private ProductsRepository repository;
    
    @Autowired
    private EntityManager manger;

    public ProductRestProcess() {
	super(ProductRequest.class, ProductResponse.class);
    }

    @Override
    public boolean validateRequest(ProductRequest restRequest, ProductResponse response) {
	return true;
    }

    @Override
    public ProductResponse process(ProductRequest restRequest, RestHeader header) {
	ProductResponse response = new ProductResponse();
	List<Product> listEntity = repository.findAll();
	listEntity = manger.createNativeQuery("select * from product", Product.class).getResultList();
	if(listEntity.isEmpty() || listEntity == null) {
	    response.setResponseCode("0001");
	    response.setResponseDesc(this.getMassageDesc("0001", "vn"));
	}else {
	    response.setResponseCode("0000");
	    response.setResponseDesc(this.getMassageDesc("0000", "vn"));
	}
	    
	List<ProductDTO> list = new ArrayList<ProductDTO>();
	for(Product entity: listEntity) {
	    ProductDTO dto = new ProductDTO();
	    dto.setCode(entity.getCode());
	    list.add(dto);
	}
	
	response.setList(list);
	return response;
    }

 
}