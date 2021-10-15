package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tokens_remember_password")
@NoArgsConstructor
public class TokenRememberPassword extends Token {
    public TokenRememberPassword(User user, String token) {
        super(user,token);
    }
}
