package com.ita.edu.greencity.tools.jdbc.services;

import com.ita.edu.greencity.tools.jdbc.dao.OrdersDao;
import com.ita.edu.greencity.tools.jdbc.entity.OrdersEntity;

public class OrderService {
    private final OrdersDao ordersDao;

    public OrderService() {
        this.ordersDao = new OrdersDao();
    }

    public void deleteById(long id) {
        ordersDao.deleteById(id);
    }

    public OrdersEntity getOrdersById(long id) {
        return ordersDao.selectById(id);
    }

    public void createOrder(OrdersEntity entity){
        ordersDao.insert(entity);
    }
}
