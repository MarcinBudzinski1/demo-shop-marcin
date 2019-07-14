package com.example.demoshopmarcin.users;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class UserDataDTO {
    @NotBlank(message = "Pole musi zostać wypełnione")
    public String street;
    @NotBlank(message = "Pole musi zostać wypełnione")
    public String building;
    @NotBlank(message = "Pole musi zostać wypełnione")
    public String flat;
    @NotBlank(message = "Pole musi zostać wypełnione")
    public String city;
    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Nie ma takiego kodu pocztowego")
    public String zipCode;
    public String country;
    @Pattern(regexp = "^(\\+\\d{1,3} )?(\\d{3}-?){2}\\d{3}$",message = "Numer telefonu może składać się z kierunkowego kraju i 9 cyfr bądź z samych 9 cyfr (dozwolone myślniki)")
    public String phone;

}
