package com.shop.rest.response;

import java.util.List;

import com.shop.dto.ProductDTO;
import com.shop.rest.base.BaseRestRespond;

public class ProductResponse extends BaseRestRespond {
    
    public List<ProductDTO> getList() {
        return list;
    }
    public void setList(List<ProductDTO> list) {
        this.list = list;
    }
    /**
     * 
     */
    private static final long serialVersionUID = 7141361690338508107L;
    public List<ProductDTO> list ;	
}
