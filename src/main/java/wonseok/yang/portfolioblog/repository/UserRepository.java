package wonseok.yang.portfolioblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wonseok.yang.portfolioblog.model.User;

//DAO와 같다.
//자동으로 Bean등록 가능 (@Repository생략 가능)
public interface UserRepository extends JpaRepository<User, Integer> { //User테이블이 관리하는 Repo다. Key는 Int형이다
//CRUD정도에서 필요한 함수는 JpaRepository가 모두 갖고있기때문에 이렇게만 해도 다 호출 됨.

    //JPA Naming 쿼리전략
    //SELECT * FROM user WHERE username=? AND password=?; 자동완성. Spring이 해줌.
    User findByUsernameAndPassword(String username, String paassword);

    /*@Query(value="SELECT * FROM user WHERE username=? AND password=?", nativeQuery = true)
    User login(String username, String password);*/ //이렇게 해도 됨(위와 같음)
}
