package com.callor.iolist.exec;

import com.callor.iolist.service.ProductService;
import com.callor.iolist.service.impl.ProductServicImplV1;

public class ExecD {
	
	public static void main(String[] args) {
		ProductService productService = new ProductServicImplV1();
		
		productService.insert();
	}

}
