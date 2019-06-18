package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.User;

import java.util.List;

public interface UserService {

    User Create(User user);
    User Login(User user);
    User GetUserInfo(String account);
    List<User> GetAllUserInfo();
    User Update(User user);
    boolean Delete(User user);

}
