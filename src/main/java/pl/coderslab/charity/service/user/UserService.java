package pl.coderslab.charity.service.user;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.coderslab.charity.dto.UserDtoRegister;
import pl.coderslab.charity.entity.User;

@Service
public interface UserService {
    void registerNewUserAccount(UserDtoRegister userDto);

    boolean validUser(UserDtoRegister userDto, BindingResult result);

    boolean validNewUser(UserDtoRegister userDto, BindingResult result);

    User findByEmailIgnoreCase(String emailTo);

    User convertToEntity(UserDtoRegister userDtoRegister);

    String accountActivation(String token);
}
