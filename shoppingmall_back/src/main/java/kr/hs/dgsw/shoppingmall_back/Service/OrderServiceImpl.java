package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Order;
import kr.hs.dgsw.shoppingmall_back.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order Create(Order order) {
        System.out.println(order);

        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> findMyOrderList(String userAccount) {
        Optional<List<Order>> found = this.orderRepository.findByUserAccount(userAccount);

        if(found != null) {
            return found.get();
        }

        return null;
    }
}
