package kr.hs.dgsw.shoppingmall_back.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String subCategory;

    private String thumbnailPath;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private int mileage;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int remainAmount;

    @Column(nullable = false, length = 40)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String notice;

    @Column(nullable = false)
    private int originalPrice;

    @Column(nullable = false)
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "productId")
    private List<Comment> comments;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
}
