package ru.kustikov.cakes.orders;

import lombok.Data;
import ru.kustikov.cakes.products.Product;

@Data
public class ProductOrder {
    private Product product;

    private Integer quantity;
}
