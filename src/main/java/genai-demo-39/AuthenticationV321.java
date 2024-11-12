```java
//src/main/java/com/example/loginapi/LoginApiApplication.java
package com.example.loginapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginApiApplication {

    /**
     * Main method to start the Spring Boot application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(LoginApiApplication.class, args);
    }
}

//src/main/java/com/example/loginapi/controller/LoginController.java
package com.example.loginapi.controller;

import com.example.loginapi.model.LoginRequest;
import com.example.loginapi.model.LoginResponse;
import com.example.loginapi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * Endpoint to handle login requests.
     * @param loginRequest contains the login credentials
     * @return returns response message with status
     */
    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}

//src/main/java/com/example/loginapi/model/LoginRequest.java
package com.example.loginapi.model;

public class LoginRequest {

    private String username;
    private String password;

    // Getters and Setters are omitted for brevity

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

//src/main/java/com/example/loginapi/model/LoginResponse.java
package com.example.loginapi.model;

public class LoginResponse {

    private String message;
    private boolean success;

    // Constructor, Getters and Setters are omitted for brevity

    public LoginResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

//src/main/java/com/example/loginapi/service/LoginService.java
package com.example.loginapi.service;

import com.example.loginapi.model.LoginRequest;
import com.example.loginapi.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    /**
     * Method to process login logic.
     * @param loginRequest contains the login credentials
     * @return the response of login attempt
     */
    public LoginResponse login(LoginRequest loginRequest) {
        if ("admin".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            // Security: Avoid hardcoding sensitive information in production code
            return new LoginResponse("Login successful", true);
        } else {
            return new LoginResponse("Invalid username or password", false);
        }
    }
}
```