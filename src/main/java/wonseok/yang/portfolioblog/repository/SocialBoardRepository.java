package wonseok.yang.portfolioblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wonseok.yang.portfolioblog.model.JobBoard;
import wonseok.yang.portfolioblog.model.SocialBoard;

public interface SocialBoardRepository extends JpaRepository<SocialBoard, Integer> {


}
