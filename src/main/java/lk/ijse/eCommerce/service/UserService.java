package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.UserDTO;

import java.util.List;

public interface UserService {

    public boolean addUser(UserDTO userDTO);

    public boolean removeUser(String userName);

    public boolean updateUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();

    public UserDTO getUser(String userName);

}
