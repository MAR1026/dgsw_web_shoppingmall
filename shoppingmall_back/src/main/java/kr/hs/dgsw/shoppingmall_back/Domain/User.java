package kr.hs.dgsw.shoppingmall_back.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String account;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

        } catch (NoSuchAlgorithmException e) {
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(e.getMessage());
            this.password = null;
        }
    }

    @Column(nullable = false)
    private String name;

    @Column()
    private String tel;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false)
    private String zip;

    @Column(nullable = false)
    private String address;

    @Column(unique = true)
    private String email;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
}
