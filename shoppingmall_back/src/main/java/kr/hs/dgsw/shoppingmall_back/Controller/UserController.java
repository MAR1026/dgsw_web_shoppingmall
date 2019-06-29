package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.User;
import kr.hs.dgsw.shoppingmall_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public User Create(@RequestBody User user) {
        return this.userService.Create(user);
    }

    @GetMapping(value = "/find/{account}")
    public User findUser(@PathVariable String account) {
        return this.userService.GetUserInfo(account);
    }

    @GetMapping(value = "/findAccountById/{id}")
    public String findAccountById(@PathVariable Long id) {
        return this.userService.findAccountById(id);
    }

    @GetMapping(value = "/findAll")
    public List<User> findAllUser() {
        return this.userService.GetAllUserInfo();
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user) {
        return this.userService.Login(user);
    }

    @PutMapping(value = "/update")
    public User update(@RequestBody User user) {
        return this.userService.Update(user);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestBody User user) {
        return this.userService.Delete(user);
    }
}
