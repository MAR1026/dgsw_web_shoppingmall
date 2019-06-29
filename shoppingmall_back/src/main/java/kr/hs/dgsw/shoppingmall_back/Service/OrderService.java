package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Order;

import java.util.List;

public interface OrderService {
    Order Create(Order order);
    List<Order> findMyOrderList(String userAccount);
}
