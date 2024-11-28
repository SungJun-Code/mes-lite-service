package com.custom.mes.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.custom.mes.order.model.WorkOrderInfo;
import com.custom.mes.util.DBUtils;

@Service
public class WorkOrderService {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public WorkOrderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public List<WorkOrderInfo> findAll(){
		List<WorkOrderInfo> output = new ArrayList<>();
		output = (List<WorkOrderInfo>) DBUtils.executeSqlFile(jdbcTemplate, "selectALL.sql");
		return output;
	}
	
    public List<WorkOrderInfo> findById(String factoryCode, String orderNo) {
        //return orderRepository.findById(id).orElse(null);
    	List<WorkOrderInfo> workOrder = new ArrayList<>();
    	workOrder = (List<WorkOrderInfo>) DBUtils.executeSqlFile(jdbcTemplate, "selectOrderNo.sql", factoryCode, orderNo);
    	return workOrder;
    }
    
    public Boolean save(WorkOrderInfo order) {
        //return orderRepository.save(order);
    	return true;
    }
    
    public Boolean updateOrder(Long id, WorkOrderInfo orderDetails) {
//    	WorkOrderInfo order = getOrderById(id);
//        if (order != null) {
//            order.setOrderId(orderDetails.getOrderId());
//            order.setProduct(orderDetails.getProduct());
//            order.setQuantity(orderDetails.getQuantity());
//            order.setPrice(orderDetails.getPrice());
//            order.setOrderDate(orderDetails.getOrderDate());
//            return orderRepository.save(order);
//        }
        return true;
    }
    
    public void deleteById(String id) {
    	
    }
    
}
