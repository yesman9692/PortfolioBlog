package wonseok.yang.portfolioblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wonseok.yang.portfolioblog.model.RoleType;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.repository.UserRepository;

import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    @GetMapping("/dummy/user/{id}") //주소로 파라미터를 전달 받을 수 있음
    public User detail(@PathVariable int id) { //여기로 값이 들어옴
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
            }
        });
        return user;
    }


    //http://localhost:8000/blog/dummy/join
    //body에 username,password,email을 가지고 요청하면 같은 이름의 파라미터로 들어감
    @PostMapping("/dummy/join")
    public String join(User user) { //key:value형태로 들어옴
                        //User user로 객체로 받을 수도 있음
        System.out.println("username: " + user.getUsername()); //객체로 받으면 get메소드로 꺼내옴
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다";
    }
}
