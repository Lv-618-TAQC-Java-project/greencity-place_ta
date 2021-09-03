package com.ita.edu.greencity.tools.jdbc.dao;

import com.ita.edu.greencity.tools.jdbc.entity.OrdersEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrdersDao {
    public void insert(OrdersEntity ordersEntity) {
        Statement statement = ManagerDao.getInstance().getStatement();
        try {
            ResultSet resultSet = statement.executeQuery(String.format(OrdersEntity.INSERT,
                    ordersEntity.getComment(),
                    ordersEntity.getDeliverFrom(),
                    ordersEntity.getNote(),
                    ordersEntity.getOrderDate(),
                    ordersEntity.getOrderStatus(),
                    ordersEntity.getPointsToUse(),
                    ordersEntity.getReceivingStation(),
                    ordersEntity.getUbsUserId(),
                    ordersEntity.getUsersId(),
                    ordersEntity.getOrderPaymentStatus(),
                    ordersEntity.getCalcellationReason(),
                    ordersEntity.getCalcellationComment()));
//            return Long.valueOf(ManagerDao.getInstance().parseResultSet(resultSet).get(0).get(0));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ManagerDao.closeStatement(statement);
    }


    public OrdersEntity selectById(long id) {
        Statement statement = ManagerDao.getInstance().getStatement();
        List<List<String>> raws = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(OrdersEntity.SELECT_BY_ID, id));
            raws = ManagerDao.getInstance().parseResultSet(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ManagerDao.closeStatement(statement);
        List<OrdersEntity> ordersEntities = OrdersEntity.getListOrdersEntity(raws);
        return ordersEntities.size() > 0 ? ordersEntities.get(0) : null;
    }

    public void deleteById(long id) {
        Statement statement = ManagerDao.getInstance().getStatement();
        try {
            statement.executeQuery(String.format(OrdersEntity.DELETE_BY_ID, id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ManagerDao.closeStatement(statement);
    }
}
