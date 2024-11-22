package com.custom.mes.order.model;

import lombok.RequiredArgsConstructor;
//import io.swagger.annotations.ApiOperation;

//@Entity
public class OrderModel {
	
    //@RequiredArgsConstructor
	//@ApiModelProperty("invLotId")
    private Long id;
    private String orderId;
    private String product;
    private int quantity;
    private double price;
    private String orderDate;

    // Getters and Setters
}
