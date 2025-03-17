package com.mgumussoy.kodluyoruz.tutorials.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "Teacher name is required")
    @Size(min=1, max=255)
    private String teacherNameSurname;

    @NotEmpty(message = "Teacher email is required")
    @Email(message = "Please enter a valid email")
    private String teacherEmail;

    @NotEmpty(message = "Teacher password is required")
    @Size(min=10, max=18, message = "Password must be between 10 and 18 characters")
    private String teacherPassword;
}
