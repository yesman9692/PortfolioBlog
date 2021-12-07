package wonseok.yang.portfolioblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional //성공하면 commit, 실패하면 rollback
    public int 회원가입(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService:회원가입(): " + e.getMessage());
        }
        return -1;
    }

    @Transactional(readOnly = true) //select할 때 시작, 종료시에 commit(정합성). select를 여러번 하더라도 에러x
    public User 로그인(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
