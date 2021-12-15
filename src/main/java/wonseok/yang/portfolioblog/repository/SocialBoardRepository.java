package wonseok.yang.portfolioblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wonseok.yang.portfolioblog.model.JobBoard;

public interface SocialBoardRepository extends JpaRepository<JobBoard, Integer> {


}
