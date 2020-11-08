package pl.sda.finalapp.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/registration")
    public String registrationForm(){
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        return "registrationPage";
    }
}
