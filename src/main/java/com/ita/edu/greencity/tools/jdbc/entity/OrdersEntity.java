package com.ita.edu.greencity.tools.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

enum OrdersEntityFields {
    ID(0),
    COMMENT(1),
    DELIVER_FROM(2),
    DELIVER_TO(3),
    NOTE(4),
    ORDER_DATE(5),
    ORDER_STATUS(6),
    POINTS_TO_USE(7),
    RECEIVING_STATION(8),
    UBS_USER_ID(9),
    USERS_ID(10),
    ORDER_PAYMENT_STATUS(11),
    CANCELLATION_REASON(12),
    CANCELLATION_COMMENT(13);

    private final int number;

    OrdersEntityFields(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

public class OrdersEntity {
    public static final String INSERT = "INSERT INTO orders (COMMENT, DELIVER_FROM, DELIVER_TO, NOTE, ORDER_DATE, ORDER_STATUS, POINTS_TO_USE, RECEIVING_STATION, " +
            "UBS_USER_ID, USERS_ID, ORDER_PAYMENT_STATUS, CANCELLATION_REASON, CANCELLATION_COMMENT) values (%s, %d, %d, %s, %d, %s, %d, %s, %d, %d, %s, %s, %s) RETURNING id";
    public static final String SELECT_ALL = "SELECT * FROM orders;";
    public static final String SELECT_BY_ID = "SELECT * FROM orders WHERE id=%s;";
    public static final String DELETE_BY_ID = "DELETE FROM orders WHERE id=%s;";

    private long id;
    private String comment;
    private long deliverFrom;
    private long deliverTo;
    private String note;
    private long orderDate;
    private String orderStatus;
    private long pointsToUse;
    private String receivingStation;
    private long ubsUserId;
    private long usersId;
    private String orderPaymentStatus;
    private String calcellationReason;
    private String calcellationComment;

    public OrdersEntity(String comment,
                        long deliverFrom,
                        long deliverTo,
                        String note,
                        long orderDate,
                        String orderStatus,
                        long pointsToUse,
                        String receivingStation,
                        long ubsUserId,
                        long usersId,
                        String orderPaymentStatus,
                        String calcellationReason,
                        String calcellationComment) {
        this.comment = comment;
        this.deliverFrom = deliverFrom;
        this.deliverTo = deliverTo;
        this.note = note;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.pointsToUse = pointsToUse;
        this.receivingStation = receivingStation;
        this.ubsUserId = ubsUserId;
        this.usersId = usersId;
        this.orderPaymentStatus = orderPaymentStatus;
        this.calcellationReason = calcellationReason;
        this.calcellationComment = calcellationComment;
    }

//    INSERT INTO orders (COMMENT, DELIVER_FROM, DELIVER_TO, NOTE, ORDER_DATE, ORDER_STATUS, POINTS_TO_USE, RECEIVING_STATION,
//                        UBS_USER_ID, USERS_ID, ORDER_PAYMENT_STATUS, CANCELLATION_REASON, CANCELLATION_COMMENT) values
//    ('Comment', '2018-12-12 12:23:23', '2018-12-12 12:23:23', '', '2018-12-12 12:23:23', '', 1, '', 143, 102, '', '', '') RETURNING id;

    public OrdersEntity() {
        this.comment = "";
        this.deliverFrom = 0;
        this.deliverTo = 0;
        this.note = "";
        this.orderDate = 0;
        this.orderStatus = "";
        this.pointsToUse = 0;
        this.receivingStation = "";
        this.ubsUserId = 0;
        this.usersId = 0;
        this.orderPaymentStatus = "";
        this.calcellationReason = "";
        this.calcellationComment = "";
    }

    public static OrdersEntity getOrdersEntity(List<String> raw) {
        return new OrdersEntity()
                .setId(Long.valueOf(raw.get(OrdersEntityFields.ID.getNumber())))
                .setComment(raw.get(OrdersEntityFields.COMMENT.getNumber()))
                .setDeliverFrom(Long.valueOf(raw.get(OrdersEntityFields.DELIVER_FROM.getNumber())))
                .setDeliverTo(Long.valueOf(raw.get(OrdersEntityFields.DELIVER_TO.getNumber())))
                .setNote(raw.get(OrdersEntityFields.NOTE.getNumber()))
                .setOrderDate(Long.valueOf(raw.get(OrdersEntityFields.ORDER_DATE.getNumber())))
                .setOrderStatus(raw.get(OrdersEntityFields.ORDER_STATUS.getNumber()))
                .setPointsToUse(Long.valueOf(raw.get(OrdersEntityFields.POINTS_TO_USE.getNumber())))
                .setReceivingStation(raw.get(OrdersEntityFields.RECEIVING_STATION.getNumber()))
                .setUbsUserId(Long.valueOf(raw.get(OrdersEntityFields.UBS_USER_ID.getNumber())))
                .setUsersId(Long.valueOf(raw.get(OrdersEntityFields.USERS_ID.getNumber())))
                .setOrderPaymentStatus(raw.get(OrdersEntityFields.ORDER_PAYMENT_STATUS.getNumber()))
                .setCalcellationReason(raw.get(OrdersEntityFields.CANCELLATION_REASON.getNumber()))
                .setCalcellationComment(raw.get(OrdersEntityFields.CANCELLATION_COMMENT.getNumber()));
    }

    public static List<OrdersEntity> getListOrdersEntity(List<List<String>> raws) {
        List<OrdersEntity> result = new ArrayList<>();
        for (List<String> raw : raws) {
            result.add(getOrdersEntity(raw));
        }
        return result;
    }

    public long getId() {
        return id;
    }

    public OrdersEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public OrdersEntity setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public long getDeliverFrom() {
        return deliverFrom;
    }

    public OrdersEntity setDeliverFrom(long deliverFrom) {
        this.deliverFrom = deliverFrom;
        return this;
    }

    public long getDeliverTo() {
        return deliverTo;
    }

    public OrdersEntity setDeliverTo(long deliverTo) {
        this.deliverTo = deliverTo;
        return this;
    }

    public String getNote() {
        return note;
    }

    public OrdersEntity setNote(String note) {
        this.note = note;
        return this;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public OrdersEntity setOrderDate(long orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public OrdersEntity setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public long getPointsToUse() {
        return pointsToUse;
    }

    public OrdersEntity setPointsToUse(long pointsToUse) {
        this.pointsToUse = pointsToUse;
        return this;
    }

    public String getReceivingStation() {
        return receivingStation;
    }

    public OrdersEntity setReceivingStation(String receivingStation) {
        this.receivingStation = receivingStation;
        return this;
    }

    public long getUbsUserId() {
        return ubsUserId;
    }

    public OrdersEntity setUbsUserId(long ubsUserId) {
        this.ubsUserId = ubsUserId;
        return this;
    }

    public long getUsersId() {
        return usersId;
    }

    public OrdersEntity setUsersId(long usersId) {
        this.usersId = usersId;
        return this;
    }

    public String getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public OrdersEntity setOrderPaymentStatus(String orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
        return this;
    }

    public String getCalcellationReason() {
        return calcellationReason;
    }

    public OrdersEntity setCalcellationReason(String calcellationReason) {
        this.calcellationReason = calcellationReason;
        return this;
    }

    public String getCalcellationComment() {
        return calcellationComment;
    }

    public OrdersEntity setCalcellationComment(String calcellationComment) {
        this.calcellationComment = calcellationComment;
        return this;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", deliverFrom=" + deliverFrom +
                ", deliverTo=" + deliverTo +
                ", note='" + note + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", pointsToUse=" + pointsToUse +
                ", receivingStation='" + receivingStation + '\'' +
                ", ubsUserId=" + ubsUserId +
                ", usersId=" + usersId +
                ", orderPaymentStatus='" + orderPaymentStatus + '\'' +
                ", calcellationReason='" + calcellationReason + '\'' +
                ", calcellationComment='" + calcellationComment + '\'' +
                '}';
    }
}
