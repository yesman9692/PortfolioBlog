package wonseok.yang.portfolioblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wonseok.yang.portfolioblog.model.Board;
import wonseok.yang.portfolioblog.model.User;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {


}
