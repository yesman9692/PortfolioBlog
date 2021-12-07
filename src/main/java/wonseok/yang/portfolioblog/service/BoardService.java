package wonseok.yang.portfolioblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wonseok.yang.portfolioblog.model.Board;
import wonseok.yang.portfolioblog.model.RoleType;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.repository.BoardRepository;
import wonseok.yang.portfolioblog.repository.UserRepository;

import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    public List<Board> 글목록() {
        return boardRepository.findAll();
    }

    @Transactional //성공하면 commit, 실패하면 rollback
    public int 글쓰기(Board board, User user) { //title, content
        try {
            board.setUser(user);
            boardRepository.save(board);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService:글쓰기(): " + e.getMessage());
            return -1;
        }
    }

    /*@Transactional(readOnly = true) //select할 때 시작, 종료시에 commit(정합성). select를 여러번 하더라도 에러x
    public User 로그인(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }*/
}
