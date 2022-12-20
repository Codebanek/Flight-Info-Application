package pl.korbanek.flightinfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.korbanek.flightinfo.functionality.CurrentUser;
import pl.korbanek.flightinfo.dto.UserCreateDTO;
import pl.korbanek.flightinfo.entity.Role;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;
import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("")
    public String basicRedirect(){
        return "redirect:/welcome";
    }
    @GetMapping(path = "/welcome")
    public String loginOrCreateUserPage(@RequestParam("error") Optional<String> error,
                                        Model model){
        if(error.isPresent()){
            model.addAttribute("loginError","Failed to login");
        }
        return "welcomePage";
    }

    @GetMapping(path = "/loginprocessing")
    public String loginProcessing(@AuthenticationPrincipal CurrentUser currentUser){
        Role role = currentUser.getUser().getRoles();
        if (role.getName().equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else
            return "redirect:/user/flightplan";
    }

    private final UserServiceImpl userServiceImpl;
    private final BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/createAccount")
    public String form(Model model) {
        model.addAttribute("user", new UserCreateDTO());
        return "createUserForm";
    }
    @PostMapping("/createAccount")
    public String saveUser(@ModelAttribute("user") @Valid UserCreateDTO userCreateDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("bindingResult", bindingResult);
            return "createUserForm";
        } else{
            userServiceImpl.saveUser(userCreateDTO);
            return "redirect:/welcome";
        }
    }

    @GetMapping("/author")
    public String authorMessage() {
        return "authorText";
    }

    @GetMapping("/pw")
    @ResponseBody
    public void pw(){
        System.out.println(passwordEncoder.encode("admin"));

    }
}
