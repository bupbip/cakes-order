package ru.kustikov.cakes.orders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:4300/api/v1/order";

    public ResponseEntity<?> save(Order order) {
        if (StringUtils.isEmpty(order.getStatus())) {
            order.setStatus("CREATED");
        }
        OrderData orderData = new OrderData(order);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderData> request = new HttpEntity<>(orderData, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL + "/save", request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Order saved successfully");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

    public ResponseEntity<List<Order>> getAll(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("userId", userId);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(URL + "/get-all?userId={userId}", HttpMethod.GET, entity, String.class, userId);
        if (response.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Order> orderList = objectMapper.readValue(response.getBody(), new TypeReference<>() {
                });
                return ResponseEntity.ok(orderList);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(500).build();
            }
        } else {
            log.error("Запрос завершился неудачно. Код ответа: " + response.getStatusCode().value());
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }
}
