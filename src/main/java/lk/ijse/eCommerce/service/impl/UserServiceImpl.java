package lk.ijse.eCommerce.service.impl;

import lk.ijse.eCommerce.dto.UserDTO;
import lk.ijse.eCommerce.entity.User;
import lk.ijse.eCommerce.repository.UserRepository;
import lk.ijse.eCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserName(),userDTO.getPassword(),userDTO.getImgUrl());
        userRepository.save(user);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeUser(String userName) {
        userRepository.deleteById(userName);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserName(),userDTO.getPassword(),userDTO.getImgUrl());
        userRepository.save(user);
        return true;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDTO> alUsers=new ArrayList<>();

        for(User user: users){
            UserDTO userDTO= new UserDTO(user.getUserName(),user.getPassword(),user.getImgUrl());
            alUsers.add(userDTO);
        }

        return alUsers;
    }

    @Override
    public UserDTO getUser(String userName) {
        Optional<User> user=userRepository.findById(userName);
        UserDTO userDTO= new UserDTO(user.get().getUserName(),user.get().getPassword(),user.get().getImgUrl());

        return userDTO;
    }
}
