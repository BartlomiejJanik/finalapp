package pl.sda.finalapp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserRegistrationDTO dto){
        Optional<User> optionalUser = userRepository.findByEmail(dto.geteMail());
//        if (optionalUser.isPresent()){
//            throw new RuntimeException("użytkownik o takim adresie "+dto.geteMail()+" e-mail już istnieje");
//        }
        userRepository.findByEmail(dto.geteMail())
                .ifPresent(e->{throw new RuntimeException("użytkownik o takim adresie "+dto.geteMail()+" e-mail już istnieje");});

        userRepository.save(User.applyDTO(dto));
    }
}
