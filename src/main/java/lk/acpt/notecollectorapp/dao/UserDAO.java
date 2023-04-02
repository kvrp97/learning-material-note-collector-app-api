package lk.acpt.notecollectorapp.dao;

import lk.acpt.notecollectorapp.dto.RequestSaveUserDTO;
import lk.acpt.notecollectorapp.model.User;
import lk.acpt.notecollectorapp.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    public User addUser(RequestSaveUserDTO requestSaveUserDTO) {
        User user = modelMapper.map(requestSaveUserDTO, User.class);
        return userRepo.save(user);
    }
}
