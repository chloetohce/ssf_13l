package sg.edu.nus.iss.ssf_13l.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Person {
    
    // @NotNull(message="ID must be auto-generated")
    private String id;

    @NotEmpty(message="First name is mandatory.")
    @Size(min=5, max=60, message="First name must be between 5 to 60 characters")
    private String firstName;

    @NotEmpty(message="Last name is mandatory.")
    @Size(min=5, max=60, message="Last name must be between 5 to 60 characters")
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

    public Person(String firstName, String lastName, LocalDate dob, int salary, String email) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.salary = salary;
        this.email = email;
    }

    public Person() {
    }


}