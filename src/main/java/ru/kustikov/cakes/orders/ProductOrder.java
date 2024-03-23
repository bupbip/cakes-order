package ru.kustikov.cakes.orders;

import lombok.Data;
import ru.kustikov.cakes.products.Product;

@Data
public class ProductOrder {
    private Long orderItemId;

    private Long orderId;

    private Product product;

    private Integer quantity;

    private String resultImage;
}
