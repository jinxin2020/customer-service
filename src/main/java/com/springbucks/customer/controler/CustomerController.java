package com.springbucks.customer.controler;

import com.springbucks.customer.bean.*;
import com.springbucks.customer.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CoffeeService coffeeService;

    @Value("${waiter.service.url}")
    private String url;

    @GetMapping("/menu")
    public List<Coffee> readMenu() {
            try{
                return coffeeService.getAll();
            } catch (Exception e) {
                return null;
            }

//            return null;
            // 根據訂單狀態告知顧客咖啡製作到了哪一步
        }

//    @PostMapping("/order")
//    public CoffeeOrder createAndPayOrder() {
//        NewOrderRequest orderRequest = NewOrderRequest.builder()
//                .customer(customer)
//                .items(Arrays.asList("capuccino"))
//                .build();
//        CoffeeOrder order = coffeeOrderService.create(orderRequest);
//        log.info("Create order: {}", order != null ? order.getId() : "-");
//        order = coffeeOrderService.updateState(order.getId(),
//                OrderStateRequest.builder().state(OrderState.PAID).build());
//        log.info("Order is PAID: {}", order);
//        return order;
//    }

    // 詢問自己的訂單信息
    @GetMapping("/queryOrder")
    private String queryOrder(Long id) {
        try{
            CoffeeOrder order = restTemplate
                    .getForObject(url + "/order/{id}", CoffeeOrder.class, id);
            log.info("咖啡訂單: {}", order);
        } catch (Exception e) {
            return "queryOrder NG";
        }


        return "/queryOrder OK";
        // 根據訂單狀態告知顧客咖啡製作到了哪一步
    }

}
