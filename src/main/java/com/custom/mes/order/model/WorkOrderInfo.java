package com.custom.mes.order.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "WORK_ORDER_INFO") // 테이블명을 명시적으로 지정
@Data
public class WorkOrderInfo {
	
    //@RequiredArgsConstructor
	@ApiModelProperty("factoryCode")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String factoryCode;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderNo;
    private String lineCode;
    private String matCode;
    private String priority;
    private String orderDate;
    private String createUserId;
    private String createTime;
    private String updateUserId;
    private String updateTime;

    // Getters and Setters
}
