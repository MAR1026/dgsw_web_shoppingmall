package kr.hs.dgsw.shoppingmall_back.Repository;

import kr.hs.dgsw.shoppingmall_back.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccount(String account);
    Optional<User> findByAccountAndPassword(String account, String password);
    Optional<User> findByAccountAndEmailAndPhone(String account, String email, String phone);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
}
