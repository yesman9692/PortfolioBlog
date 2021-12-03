package wonseok.yang.portfolioblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data //Getter & Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //생성자 호출 시, 객체.builder().매개변수("").매개변수("")...build(); 해서 원하는 매개변수만 사용하여 호출가능
@Entity //테이블화 시키는 어노테이션. 프로젝트가 실행될 때 이 클래스를 읽어서, 자동으로 MySQL에 테이블이 생성됨
//JPA(=ORM) -> Java 오브젝트를 Table로 매핑해주는 기술.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬머노트라는 라이브러리를 사용할 것. 글이 디자인 돼서 들어감. html태그가 섞여서 디자인 됨. -> 데이터가 커짐

    @ColumnDefault("0")
    private int count;

    @ManyToOne //Many=Board(Foreign key), User=One(Primary Key). 한 명의 유저는 여러개의 게시글을 쓸 수 있음.
    @JoinColumn(name = "userID")
    private User user; //DB는 오브젝트를 저장할 수 없음. 따라서 Foregin Key를 사용하는데, 자바는 오브젝트를 저장할 수 잇다.
                        // -> 자바와 DB가 충돌 나기 때문에 자바가 DB에 맞춰서 저장해줌.
                        // -> User오브젝트가 Foregin Key가 되어 key값을 테이블에 저장됨. (User테이블의 ID가 컬럼명:'userID' 타입:integer형으로 저장됨)

    @CreationTimestamp
    private Timestamp createDate;


}
