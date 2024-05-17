package ru.kustikov.cakes.orders;

import lombok.Data;
import ru.kustikov.cakes.users.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderData {
    private Long orderId;

    private String status;

    private Integer preferPrice;

    private Integer spentPrice;

    private Integer resultPrice;


    private User customer;

    private User confectioner;

    private LocalDateTime createdDate;

    private LocalDateTime completeDate;

    private String deliveryType;

    private String address;

    private String comment;

    private List<ProductOrder> products;

    public OrderData(Order order) {
        this.orderId = order.getOrderId();
        this.status = order.getStatus();
        this.preferPrice = order.getPreferPrice();
        this.spentPrice = order.getSpentPrice();
        this.resultPrice = order.getResultPrice();
        this.customer = order.getCustomer();
        this.confectioner = order.getConfectioner();
        this.createdDate = order.getCreatedDate().toLocalDateTime();
        this.completeDate = order.getCompleteDate().toLocalDateTime();
        this.deliveryType = order.getDeliveryType();
        this.address = order.getAddress();
        this.products = order.getProducts();
        this.comment = order.getComment();
    }
}
