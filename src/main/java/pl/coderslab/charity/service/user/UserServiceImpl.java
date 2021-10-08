package pl.coderslab.charity.service.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.role.RoleService;

@Component
@Primary
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final RoleService roleService;

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setRole(roleService.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean validUser(UserDto userDto, BindingResult result) {

//        if(userRepository.existsByEmailIgnoreCase(userDto.getEmail())){
//            result.addError(new FieldError("userDto","email","Email jest w bazie danych"));
//        }
//        if(!userDto.getPassword2().equals(userDto.getPassword())){
//            result.rejectValue("password", "password", "Popraw hasło");
//        }
        return result.hasErrors();
    }
}
