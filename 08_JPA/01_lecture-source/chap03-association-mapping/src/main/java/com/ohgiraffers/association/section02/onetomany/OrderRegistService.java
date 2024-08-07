package com.ohgiraffers.association.section02.onetomany;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderRegistService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderRegistService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void registOrder(List<OrderMenuDTO> orderInfo) {

        List<OrderMenu> orderMenus = orderInfo.stream()
                .map(orderDetail -> new OrderMenu(new OrderMenuPK(0, orderDetail.getMenuCode()), orderDetail.getOrderAmount()))
                .collect(Collectors.toList());

        Order order = new Order(
                LocalDate.now(),
                LocalTime.now(),
                95000,
                orderMenus
        );

        orderRepository.save(order);
    }
}