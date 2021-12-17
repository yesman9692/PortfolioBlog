package wonseok.yang.portfolioblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wonseok.yang.portfolioblog.model.JobBoard;
import wonseok.yang.portfolioblog.model.SocialBoard;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.model.VisitBoard;
import wonseok.yang.portfolioblog.repository.JobBoardRepository;
import wonseok.yang.portfolioblog.repository.SocialBoardRepository;
import wonseok.yang.portfolioblog.repository.VisitBoardRepository;


@Service
public class BoardService {

    @Autowired
    private JobBoardRepository jobBoardRepository;
    @Autowired
    private SocialBoardRepository socialBoardRepository;
    @Autowired
    private VisitBoardRepository visitBoardRepository;


    public Page<JobBoard> 글목록j(Pageable pageable) {
//        System.out.println("글목록j 호출");
        return jobBoardRepository.findAll(pageable);
    }
    
    public Page<SocialBoard> 글목록s(Pageable pageable) {
//        System.out.println("글목록s 호출");
        return socialBoardRepository.findAll(pageable); 
    }

    public Page<VisitBoard> 글목록v(Pageable pageable) {
//        System.out.println("글목록s 호출");
        return visitBoardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public JobBoard jobBoardDetail(int id) {
//        System.out.println("job board id:" + id);
        return jobBoardRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("job 글 상세보기 실패, id: " + id);
                    return new IllegalArgumentException("job 글 상세보기 실패: 아이디를 찾을 수 없습니다");
                });
    }

    @Transactional(readOnly = true)
    public SocialBoard socialBoardDetail(int id) {
//        System.out.println("social board id:" + id);
        return socialBoardRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("social 글 상세보기 실패, id: " + id);
                    return new IllegalArgumentException("social 글 상세보기 실패: 아이디를 찾을 수 없습니다");
                });
    }

    @Transactional(readOnly = true)
    public VisitBoard visitBoardDetail(int id) {
//        System.out.println("visit board id:" + id);
        return visitBoardRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("visit 글 상세보기 실패, id: " + id);
                    return new IllegalArgumentException("visit 글 상세보기 실패: 아이디를 찾을 수 없습니다");
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

    @Transactional
    public int 글쓰기(SocialBoard board, User user) { //title, content
        try {
            board.setUser(user);
            socialBoardRepository.save(board);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService:글쓰기(): " + e.getMessage());
            return -1;
        }
    }

    @Transactional
    public int 글쓰기(VisitBoard board, User user) { //title, content
        try {
            board.setUser(user);
            visitBoardRepository.save(board);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService:글쓰기(): " + e.getMessage());
            return -1;
        }
    }




    @Transactional
    public void jobUpdate(int id, JobBoard requestBoard) {
        System.out.println("job update service:" + id);
        JobBoard jobBoard = jobBoardRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("job 글 찾기 실패, id: " + id);
                    return new IllegalArgumentException("job 글 찾기 실패: 아이디를 찾을 수 없습니다");
                });
        jobBoard.setTitle(requestBoard.getTitle());
        jobBoard.setContent(requestBoard.getContent());
    }

    @Transactional
    public void socialUpdate(int id, SocialBoard requestBoard) {
        System.out.println("social update service:" + id);
        SocialBoard socialBoard = socialBoardRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("social 글 찾기 실패, id: " + id);
                    return new IllegalArgumentException("social 글 찾기 실패: 아이디를 찾을 수 없습니다");
                });
        socialBoard.setTitle(requestBoard.getTitle());
        socialBoard.setContent(requestBoard.getContent());
    }

    @Transactional
    public void visitUpdate(int id, VisitBoard requestBoard) {
        System.out.println("visit update service:" + id);
        VisitBoard visitBoard = visitBoardRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("visit 글 찾기 실패, id: " + id);
                    return new IllegalArgumentException("visit 글 찾기 실패: 아이디를 찾을 수 없습니다");
                });
        visitBoard.setTitle(requestBoard.getTitle());
        visitBoard.setContent(requestBoard.getContent());
    }




    @Transactional
    public void deleteJob(int id) {
        jobBoardRepository.deleteById(id);
    }

    @Transactional
    public void deleteSocial(int id) {
        socialBoardRepository.deleteById(id);
    }

    @Transactional
    public void deleteVisit(int id) {
        visitBoardRepository.deleteById(id);
    }

    /*@Transactional(readOnly = true) //select할 때 시작, 종료시에 commit(정합성). select를 여러번 하더라도 에러x
    public User 로그인(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }*/
}
