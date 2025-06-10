package com.chinmay.Resource_Sharing.Controller;
import com.chinmay.Resource_Sharing.Entity.UserEntity;
import com.chinmay.Resource_Sharing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/main")
public class UsersController {
    @Autowired
    UserService service;
    @PostMapping("/send")
    public ResponseEntity<String> add(@RequestBody UserEntity u) {

       service.addUser(u);
       return  new ResponseEntity<>("data saved", HttpStatus.OK);
    }

    @GetMapping("/alldbdata")
    public List<UserEntity> allDbData(){

     return    service.getAllDbData();

    }

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody UserEntity user){

  List<UserEntity> u=    service.getAllDbData();
    for(UserEntity u1:u)

    {

        if(u1.getName().equals(user.getName())&&u1.getPassword().equals(user.getPassword())){

          return new ResponseEntity<>("login success fully",HttpStatus.OK)  ;
        }
    }
    return new ResponseEntity<>("invalid credentilas",HttpStatus.NOT_FOUND);
    }
}
