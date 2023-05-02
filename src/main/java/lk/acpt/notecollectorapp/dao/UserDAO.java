package lk.acpt.notecollectorapp.dao;

import lk.acpt.notecollectorapp.dto.request.RequestLogUserDTO;
import lk.acpt.notecollectorapp.dto.request.RequestSaveUserDTO;
import lk.acpt.notecollectorapp.model.User;
import lk.acpt.notecollectorapp.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDAO {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public boolean addUser(RequestSaveUserDTO saveUserDTO) {
        if(!userRepo.existsByEmailAddress(saveUserDTO.getEmailAddress())){
            User user = modelMapper.map(saveUserDTO, User.class);
            userRepo.save(user);
            return true;
        } else {
            return false;
        }
    }

    public Map authenticateUser(RequestLogUserDTO logUserDTO) throws Exception {
        Map<String, String> auth = new HashMap<>();
        User user = userRepo.getUserByEmailAddress(logUserDTO.getEmailAddress()).orElseThrow(() -> new Exception("No user found"));
        if (user.getPassword().equals(logUserDTO.getPassword())){
            auth.put("user",user.getFirstName());
        } else {
            auth.put(null,null);
        }
        return auth;
    }
}
