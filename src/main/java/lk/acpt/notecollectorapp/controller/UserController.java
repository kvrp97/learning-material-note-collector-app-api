package lk.acpt.notecollectorapp.controller;

import lk.acpt.notecollectorapp.dao.UserDAO;
import lk.acpt.notecollectorapp.dto.request.RequestLogUserDTO;
import lk.acpt.notecollectorapp.dto.request.RequestSaveUserDTO;
import lk.acpt.notecollectorapp.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveUser(@RequestBody RequestSaveUserDTO saveUserDTO){
        try {
            boolean userSaved = userDAO.addUser(saveUserDTO);
            if (userSaved){
                return new ResponseEntity<>(
                        new StandardResponse(201,"Success", true),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        new StandardResponse(409,"Email already in use",false),
                        HttpStatus.CONFLICT
                );
            }
        } catch (Exception e){
            return new ResponseEntity<>(
                    new StandardResponse(500, e.getMessage(), false),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<StandardResponse> authenticateUser(@RequestBody RequestLogUserDTO logUserDTO){
        try {
            Map isAuthenticated = userDAO.authenticateUser(logUserDTO);
            if (isAuthenticated.containsKey("user")) {
                return new ResponseEntity<>(
                        new StandardResponse(200, "Authentication Success", isAuthenticated),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new StandardResponse(401, "Unauthorized", false),
                        HttpStatus.UNAUTHORIZED
                );
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new StandardResponse(404, e.getMessage(), null),
                    HttpStatus.NOT_FOUND
            );
        }
    }

}
