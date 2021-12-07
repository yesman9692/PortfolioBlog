package wonseok.yang.portfolioblog.Controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wonseok.yang.portfolioblog.DTO.ResponseDTO;
import wonseok.yang.portfolioblog.model.RoleType;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class UserAPIController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDTO<Integer> save(@RequestBody User user) { //username, password, email
        System.out.println("UserApiController: save호출됨");
        int result = userService.회원가입(user);
        return new ResponseDTO<Integer>(HttpStatus.OK, result);
    }

    //전통적인 로그인 방식
    /*@PostMapping("/api/user/login")
    public ResponseDTO<Integer> login(@RequestBody User user, HttpSession session) {
        System.out.println("User ApiController: login 호출됨");
        User principal = userService.로그인(user); //principal=접근주체

        if(principal!=null){
            session.setAttribute("principal", principal);
        } else{
            System.out.println("Session획득 실패(principal: " + principal);
        }
        return new ResponseDTO<Integer>(HttpStatus.OK, 1);
    }*/

}
