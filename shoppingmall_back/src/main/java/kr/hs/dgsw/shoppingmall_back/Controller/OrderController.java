package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.Order;
import kr.hs.dgsw.shoppingmall_back.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create")
    public Order Create(@RequestBody Order order) {
        return this.orderService.Create(order);
    }

    @GetMapping(value = "/find/{account}")
    public List<Order> findAll(@PathVariable String account) {
        return this.orderService.findMyOrderList(account);
    }

}
