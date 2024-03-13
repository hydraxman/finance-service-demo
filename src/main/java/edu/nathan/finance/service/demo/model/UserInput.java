package edu.nathan.finance.service.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInput {
    private String username;
    private String email;
    private String password;
    private String role;
    private String status;
    private String createdAt;
}