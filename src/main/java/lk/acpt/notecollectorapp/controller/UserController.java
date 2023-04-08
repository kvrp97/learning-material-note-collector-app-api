package lk.acpt.notecollectorapp.controller;

import lk.acpt.notecollectorapp.dao.UserDAO;
import lk.acpt.notecollectorapp.dto.RequestSaveUserDTO;
import lk.acpt.notecollectorapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserDAO userDAO;

    //save user
    @PostMapping(path = "/save")
    public boolean saveUser(@RequestBody RequestSaveUserDTO requestSaveUserDTO){
        return userDAO.addUser(requestSaveUserDTO);
    }

    //get user
    @GetMapping(path = "/get-user", params = "email")
    public User getUser(@RequestParam(value = "email") String emailAddress){
        return userDAO.getUser(emailAddress);
    }

}
