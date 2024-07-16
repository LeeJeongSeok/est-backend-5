package net.chimaek.day0715;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model) {
        User max = new User("max", "max@gmail.com", true);
        TiramisuCake tiramisuCake = new TiramisuCake("티라미슈 케잍~T라 미숙해~");

        model.addAttribute("username", max.getUsername());
        model.addAttribute("email", max.getEmail());
        model.addAttribute("admin", max.isAdmin());
        model.addAttribute("text", tiramisuCake.getText());
        model.addAttribute("user", max);


        return "index";
    }

    @GetMapping("/index/2")
    public String index2() {
        return "index2";
    }

    @PostMapping("/users")
    public String users(@ModelAttribute User user) {

        System.out.println("유저의 이름은" + user.getUsername() + "입니다.");
        System.out.println("유저의 이메일은" + user.getEmail() + "입니다.");

        return "index2";
    }
}