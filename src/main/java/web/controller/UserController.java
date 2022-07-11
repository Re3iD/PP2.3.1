package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public String getUsers(Model model){
        model.addAttribute("userList",userService.listUsers());
        return "users/users";
    }
    @GetMapping("/new")
    public String newUserForm(Model model){
        model.addAttribute("newUser", new User());
        return "users/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") int id) {
        userService.delete(userService.getUserById(id));
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") int id, Model model){
        model.addAttribute("userOne", userService.getUserById(id));
        return "users/user";
    }

}
