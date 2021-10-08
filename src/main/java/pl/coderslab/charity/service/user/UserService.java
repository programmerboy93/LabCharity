package pl.coderslab.charity.service.user;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.coderslab.charity.dto.UserDto;

@Service
public interface UserService {
    void save(UserDto userDto);

    boolean validUser(UserDto userDto, BindingResult result);
}
