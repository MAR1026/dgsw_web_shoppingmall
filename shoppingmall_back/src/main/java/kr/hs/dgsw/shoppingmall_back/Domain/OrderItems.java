package kr.hs.dgsw.shoppingmall_back.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int quantity;

}
