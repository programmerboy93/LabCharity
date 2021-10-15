package pl.coderslab.charity.service.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import pl.coderslab.charity.dto.UserDtoRegister;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.VerificationToken;
import pl.coderslab.charity.mail.MailService;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.token.VerificationTokenService;

import javax.transaction.Transactional;
import java.util.UUID;

@Component
@Primary
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenService verificationTokenService;
    private final MailService mailService;

    @Override
    public User convertToEntity(UserDtoRegister userDtoRegister) {
        return modelMapper.map(userDtoRegister, User.class);
    }

    @Override
    public User findByEmailIgnoreCase(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    //when an exception occurs, roll back the changes from the database
    public void registerNewUserAccount(UserDtoRegister userDtoRegister) {
        User user = modelMapper.map(userDtoRegister, User.class);
        String token = UUID.randomUUID().toString();
        user.setRole(new Role(1l, "ROLE_USER"));
        user.setPassword(passwordEncoder.encode(userDtoRegister.getPassword()));
        User result = userRepository.save(user);
        verificationTokenService.save(new VerificationToken(result,token));
        mailService.sendMailWithNewToken(user.getEmail(), token);
    }

    @Override
    public boolean validUser(UserDtoRegister userDto, BindingResult result) {
        if (userRepository.existsByEmailIgnoreCase(userDto.getEmail())) {
            result.addError(new FieldError("userDto", "email", "Email jest w bazie danych"));
        }
        if (!userDto.getPassword2().equals(userDto.getPassword())) {
            result.rejectValue("password", "password", "Popraw hasło");
        }
        return result.hasErrors();
    }

    @Override
    public boolean validNewUser(UserDtoRegister userDtoRegister, BindingResult result) {
        result.addError(new FieldError("user", "email", "Email jest w bazie danych"));
        return result.hasErrors();
    }

    @Override
    @Transactional
    public String accountActivation(String token) {
        VerificationToken tokenRegister = verificationTokenService.findByToken(token);
        if (tokenRegister != null) {
            tokenRegister.getUser().setEnabled(true);
            userRepository.save(tokenRegister.getUser());
            verificationTokenService.destroy(tokenRegister);
            return "Konto jest już aktywne możesz się zalogować";
        } else {
            return "Wystąpił błąd spróbuj ponownie później";
        }
    }
}
