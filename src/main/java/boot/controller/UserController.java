package boot.controller;

import boot.model.User;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public String user(@CurrentSecurityContext(expression = "authentication.principal") User principal, Model model){
        model.addAttribute("user", principal);
        return "user";
    }
}
