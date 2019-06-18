package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.User;
import kr.hs.dgsw.shoppingmall_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User Create(User user) {
        System.out.println(user.getAccount());

        if(this.userRepository.findByAccountAndEmailAndPhone(user.getAccount(), user.getEmail(), user.getPhone()).isPresent()) {
            return null;
        } else {
            return this.userRepository.save(user);
        }
    }

    @Override
    public User Login(User user) {
        System.out.println(user.getAccount());

        Optional<User> found = this.userRepository.findByAccountAndPassword(user.getAccount(), user.getPassword());

        if(found.isPresent()) {
            return found.get();
        } else {
            return null;
        }
    }

    @Override
    public User GetUserInfo(String account) {
        Optional<User> found = this.userRepository.findByAccount(account);

        if(found.isPresent()) {
            return found.get();
        } else {
            return null;
        }
    }

    @Override
    public List<User> GetAllUserInfo() {
        return this.userRepository.findAll();
    }

    @Override
    public User Update(User user) {
        User found = GetUserInfo(user.getAccount());

        if(found != null) {
            found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
            found.setAddress(Optional.ofNullable(user.getAddress()).orElse(found.getAddress()));
            found.setZip(Optional.ofNullable(user.getZip()).orElse(found.getZip()));
            found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
            found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
            found.setTel(Optional.ofNullable(user.getTel()).orElse(found.getTel()));

            return this.userRepository.save(found);
        } else {
            return null;
        }
    }

    @Override
    public boolean Delete(User user) {
        User found = GetUserInfo(user.getAccount());

        if(found != null) {
            this.userRepository.deleteById(found.getId());
            return true;
        } else {
            return false;
        }
    }
}
