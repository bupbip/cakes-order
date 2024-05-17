package ru.kustikov.cakes.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ru.kustikov.cakes.filling.Filling;
import ru.kustikov.cakes.producttype.ProductType;

import java.sql.Timestamp;
import java.util.List;

@Data
public class User {
    private Long userId;

    private String email;

    private String phone;

    private String username;

    private String description;

    private String password;

    private String role;

    private String image;

    private Timestamp lastActivity;

    private List<ProductType> productTypes;

    private List<Filling> fillings;

    private List<Object> consumables;

    @JsonIgnore
    private Object socialNetworks;

    private Object subscriptions;

    private Object feedbacksTo;
}
