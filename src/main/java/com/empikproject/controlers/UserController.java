package com.empikproject.controlers;

import com.empikproject.domain.User;
import com.empikproject.domain.exception.ApiException;
import com.empikproject.domain.exception.ServiceUnavailableException;
import com.empikproject.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("{login}")
    public ResponseEntity<User> get(@PathVariable String login){
        return new ResponseEntity<>(userService.get(login), HttpStatus.OK);
    }

    @ExceptionHandler({ApiException.class})
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler() {
        return "user with provided login not found";
    }

    @ExceptionHandler({ServiceUnavailableException.class})
    @ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE)
    public String serviceUnavailableExceptionHandler() {
        return "Internal error";
    }
}
