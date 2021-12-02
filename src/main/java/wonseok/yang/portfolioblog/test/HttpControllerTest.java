package wonseok.yang.portfolioblog.test;

import org.springframework.web.bind.annotation.*;

//@Controller 사용자가 요청 -> 응답(HTML)
@RestController //사용자가 요청 -> 응답(data)
public class HttpControllerTest {

    //인터넷 브라우저 요청은 무조건 get밖에 할 수 없다. 다른 요청은 405에러.
    @GetMapping("http/get")//get = select <데이터를 주세요>
    public String getTest(@RequestParam int id, @RequestParam String username) { //RequestParam으로 데이터 받기
        return "get 요청" + id + ", " + username;
    }

    @GetMapping("http/get/member") //id=1&username=ssar&password=1234&email=ssar@naver.com
    public String getTest(Member m) { //Spring이 알아서 응답을 Member객체에 담아줌
        return "get 요청, " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }
    //SpringBoot의 MessageConverter가 응답을 객체에 맵핑해줌.
    @PostMapping("http/post")
    public String postTest(Member m) { //post = insert <데이터를 추가해주세요>
        return "post 요청, " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
        //post는 body에 실어서 보내는데 그 방법이 여러가지이다.
        //x-www-form-urlencoded : <form> <input type=""> </form>태그 안에 데이터를 실어서 요청
        //raw-text : @RequestBody String s를 매개변수로 받음. text/plain형식으로 받기때문에 어떤 데이터가 와도 됨.
        //raw-JSON : @RequestBody Member m을 매개변수로 받음. m에 JSON 데이터가 파싱되어서 저장됨.
    }

    @PutMapping("http/put") //put = update <데이터를 수정해주세요>
    public String putTest(@RequestBody Member m) {
        return "put 요청, " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @DeleteMapping("http/delete")
    public String deleteTest() { //delete = delete <데이터를 삭제해주세요>
        return "delete 요청";
    }
}
