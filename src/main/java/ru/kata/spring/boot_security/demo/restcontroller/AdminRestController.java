package ru.kata.spring.boot_security.demo.restcontroller;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminRestController {
    private final UserService userService;
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public List<User> allUsers() {
        return userService.listUsers();
    }
//    @GetMapping("/{id}")
//    public User getUser (@PathVariable long id) {
//        return userService.findById(id);
//    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) throws Exception {
        userService.saveUser(user);
        return user;
    }

    @PutMapping()
    public  User updateUser(@RequestBody User user) throws Exception {
        userService.updateUser(user);
        return user;
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "User with ID = " + id + " was deleted";
    }

}
