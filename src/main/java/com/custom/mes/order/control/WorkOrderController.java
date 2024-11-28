package com.custom.mes.order.control;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.custom.mes.order.model.WorkOrderInfo;

//@RestController
@RequestMapping("/api/orders")
public interface WorkOrderController {

    @GetMapping
    List<WorkOrderInfo> getAllOrders();

    @GetMapping("/id")
    List<WorkOrderInfo> getOrderById(@RequestParam(name="factoryCode") String factoryCode, @RequestParam(name="orderNo") String orderNo);

    @PostMapping
    Boolean createOrder(@RequestBody WorkOrderInfo order);

    @PutMapping("/update")
    Boolean updateOrder(@RequestParam(name="factoryCode") String factoryCode, @RequestParam(name="orderNo") String orderNo, @RequestBody WorkOrderInfo order);

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable String id);
}
