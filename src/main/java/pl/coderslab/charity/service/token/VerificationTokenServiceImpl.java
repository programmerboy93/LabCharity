package pl.coderslab.charity.service.token;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.VerificationToken;
import pl.coderslab.charity.repository.VerificationTokenRepository;

@Component
@Primary
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    @Override
    public VerificationToken save(VerificationToken verificationToken) {
        return verificationTokenRepository.save(verificationToken);
    }

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    @Override
    public void destroy(VerificationToken tokenRegister) {
        verificationTokenRepository.delete(tokenRegister);
    }
}
