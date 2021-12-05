package wonseok.yang.portfolioblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import wonseok.yang.portfolioblog.model.RoleType;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id, @RequestBody User requestUser) {

        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            return "삭제 실패. 해당 ID는 존재하지 않습니다. ID: " + id;
        }
        return "삭제되었습니다 ID:" + id;
    }

    //email, password를 받아서 수정한다
    @Transactional //더티체킹: 함수 리턴시 자동으로 변경을 감지해서 commit.
    @PutMapping("/dummy/user/{id}") //Update는 Put요청
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id:" + id);
        System.out.println("pwd: " + requestUser.getPassword());
        System.out.println("email: " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패했습니다");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        return user;
    }
    @GetMapping("/dummy/user")
    public List<User> list() {
        return userRepository.findAll();
    }

    //한페이지당 2건의 데이터를 리턴
    @GetMapping("dummy/user/page")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable); //Page정보까지 반환해줌
        List<User> user = page.getContent(); //사용자가 페이지 정보까지 볼 필요는 없으므로 리스트형으로 반환
        return user;
    }


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
