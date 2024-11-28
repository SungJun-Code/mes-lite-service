package com.custom.mes.order.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.custom.mes.order.model.WorkOrderInfo;
import com.custom.mes.order.service.WorkOrderService;

@RestController
public class WorkOrderControllerImpl implements WorkOrderController {

    @Autowired
    private WorkOrderService service;

    @Override
    public List<WorkOrderInfo> getAllOrders() {
        return service.findAll();
    }

    @Override
    public List<WorkOrderInfo> getOrderById(@RequestParam(name="factoryCode") String factoryCode, @RequestParam(name="orderNo") String orderNo) {
        return service.findById(factoryCode, orderNo);
    }

    @Override
    public Boolean createOrder(@RequestBody WorkOrderInfo order) {
        return service.save(order);
    }

    @Override
    public Boolean updateOrder(@RequestParam(name="factoryCode") String factoryCode, @RequestParam(name="orderNo") String orderNo, @RequestBody WorkOrderInfo order) {
    	List<WorkOrderInfo> existingOrder = service.findById(factoryCode, orderNo);
        if (existingOrder != null) {
//            existingOrder(order.getProduct());
//            existingOrder.setQuantity(order.getQuantity());
            return service.save(existingOrder.get(0));
        }
        return null;
    }

    @Override
    public void deleteOrder(@PathVariable String id) {
        service.deleteById(id);
    }
}
