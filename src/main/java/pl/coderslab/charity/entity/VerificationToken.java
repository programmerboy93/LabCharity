package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "tokens_register")
@NoArgsConstructor
public class VerificationToken extends Token {
    public VerificationToken(User user, String token) {
        super(user, token);
    }
}
