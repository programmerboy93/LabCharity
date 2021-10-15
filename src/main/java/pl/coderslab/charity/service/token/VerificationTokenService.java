package pl.coderslab.charity.service.token;

import pl.coderslab.charity.entity.VerificationToken;

public interface VerificationTokenService {
    VerificationToken save(VerificationToken verificationToken);

    VerificationToken findByToken(String token);

    void destroy(VerificationToken tokenRegister);
}
