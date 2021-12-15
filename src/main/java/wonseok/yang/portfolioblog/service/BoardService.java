package wonseok.yang.portfolioblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wonseok.yang.portfolioblog.model.JobBoard;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.repository.JobBoardRepository;


@Service
public class BoardService {

    @Autowired
    private JobBoardRepository jobBoardRepository;


    public Page<JobBoard> 글목록(Pageable pageable)
    {
        return jobBoardRepository.findAll(pageable);
    }

    public JobBoard 글상세보기(int id) {
        return jobBoardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다");
                });
    }

    @Transactional //성공하면 commit, 실패하면 rollback
    public int 글쓰기(JobBoard board, User user) { //title, content
        try {
            board.setUser(user);
            jobBoardRepository.save(board);
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
