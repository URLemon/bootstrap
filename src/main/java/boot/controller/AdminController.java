package boot.controller;

import boot.model.User;
import boot.service.RoleService;
import boot.service.UserService;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String admin(@CurrentSecurityContext(expression = "authentication.principal") User principal, Model model){
        model.addAttribute("user", principal);
        model.addAttribute("changeUser", new User());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.findAllRoles());
        return "admin";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/adduser")
    public String addNewUser(@CurrentSecurityContext(expression = "authentication.principal") User principal,Model model){
        User user = new User();
        model.addAttribute("allRoles", roleService.findAllRoles());
        model.addAttribute("newuser", user);
        model.addAttribute("user", principal);
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("newuser") User user){
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/updateuser")
    public String updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
