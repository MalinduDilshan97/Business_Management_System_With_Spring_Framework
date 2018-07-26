package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.UserDTO;
import lk.ijse.eCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }
    @DeleteMapping(value = "{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean DeleteUser(@PathVariable("userName") String userName){
        return userService.removeUser(userName);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @GetMapping(value = "{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@PathVariable("userName") String userName){
        return userService.getUser(userName);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
}
