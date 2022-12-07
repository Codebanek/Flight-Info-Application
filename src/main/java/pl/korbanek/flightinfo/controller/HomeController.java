package pl.korbanek.flightinfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.repository.UserRepository;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("")
    public String basicRedirect(){
        return "redirect:/welcome";
    }
    @GetMapping(path = "/welcome")
    public String loginOrCreateUserPage(){
        return "welcomePage";
    }



    private final UserServiceImpl userServiceImpl;

    @GetMapping("/createAccount")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "createUserForm";
    }
    @PostMapping("/createAccount")
    public String addUser(User user){
        userServiceImpl.saveUser(user);
        return "/welcomePage";
    }

    @GetMapping("/author")
    public String authorMessage() {
        return "authorText";
    }
}
