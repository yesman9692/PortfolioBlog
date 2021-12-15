package wonseok.yang.portfolioblog.Controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wonseok.yang.portfolioblog.DTO.ResponseDTO;
import wonseok.yang.portfolioblog.configuration.auth.PrincipalDetail;
import wonseok.yang.portfolioblog.model.JobBoard;
import wonseok.yang.portfolioblog.service.BoardService;

@RestController
public class BoardAPIController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDTO<Integer> save(@RequestBody JobBoard board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardService.글쓰기(board, principalDetail.getUser());
        return new ResponseDTO<Integer>(HttpStatus.OK, 1);
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
