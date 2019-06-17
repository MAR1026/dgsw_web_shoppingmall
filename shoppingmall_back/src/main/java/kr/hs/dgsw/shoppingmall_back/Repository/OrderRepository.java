package kr.hs.dgsw.shoppingmall_back.Repository;

import kr.hs.dgsw.shoppingmall_back.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
