package wonseok.yang.portfolioblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wonseok.yang.portfolioblog.model.SocialBoard;
import wonseok.yang.portfolioblog.model.VisitBoard;

public interface VisitBoardRepository extends JpaRepository<VisitBoard, Integer> {


}
