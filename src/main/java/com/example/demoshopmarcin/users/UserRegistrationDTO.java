package com.example.demoshopmarcin.users;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Setter
@Getter
public class UserRegistrationDTO {

    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]{2,}$", message = "Wymagane przynajmniej 3 znaki(pierwsza litera duża, reszta małe).")
    public String username;
    @Pattern(regexp = "^[\\w\\.]+@[\\w]+\\.[\\w]+(\\.[a-z]{2,3})?$", message = "Zły format adresu email")
    public String eMail;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*", message = "Hasło jest wymagane. Musi zawierać od 10 do 20 znaków, jedną duża, jedna małą literę i cyfrę.")
    public String passwordHash;

}
