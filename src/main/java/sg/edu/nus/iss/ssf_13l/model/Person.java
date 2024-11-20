package sg.edu.nus.iss.ssf_13l.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Person {
    
    // @NotNull(message="ID must be auto-generated")
    private String id;

    @NotEmpty(message="First name is mandatory.")
    @Size(min=3, max=60, message="First name must be between 3 to 60 characters")
    private String firstName;

    @NotEmpty(message="Last name is mandatory.")
    @Size(min=2, max=60, message="Last name must be between 2 to 60 characters")
    private String lastName;

    @PastOrPresent(message = "DOB should be in the past or present.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Min(value = 1500, message = "Salary must starts from 1500.")
    @Max(value = 100000, message = "Salary cannot exceed 100000.")
    private int salary;

    @Email(message = "Please enter a valid email.")
    @NotBlank(message = "Email is mandatory.")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}", message="Please enter a valid phone number")
    private String phone;

    @Digits(fraction = 0, integer = 6, message = "Please enter a valid postal code.")
    @Min(value = 111111, message = "Postal code starts from 111111")
    @Max(value = 999999, message = "Postal code cannot exceed 999999")
    private int postalCode;

    public Person(String firstName, String lastName, LocalDate dob, int salary, String email, String phone, int postalCode) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.postalCode = postalCode;
    }

    public Person() {
    }


}