package ru.kustikov.cakes.orders;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import ru.kustikov.cakes.users.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long orderId;

    private String status;

    private Integer preferPrice;

    private Integer spentPrice;

    private Integer resultPrice;

    private User customer;

    private User confectioner;

    private Timestamp createdDate;

    private Timestamp completeDate;

    private String deliveryType;

    private String address;

    private String comment;

    private List<ProductOrder> products;
}
