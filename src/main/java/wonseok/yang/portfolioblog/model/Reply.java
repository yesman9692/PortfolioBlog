package wonseok.yang.portfolioblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data //Getter & Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //생성자 호출 시, 객체.builder().매개변수("").매개변수("")...build(); 해서 원하는 매개변수만 사용하여 호출가능
@Entity //테이블화 시키는 어노테이션. 프로젝트가 실행될 때 이 클래스를 읽어서, 자동으로 MySQL에 테이블이 생성됨
//JPA(=ORM) -> Java 오브젝트를 Table로 매핑해주는 기술.
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne //하나의 게시글에 여러개의 답글이 존재할 수 있음 <-> 하나의 답글에 여러개의 게시글이 존재 할 수 있음?(x)
    @JoinColumn(name = "boardID")
    private Board board; //어느 게시글에 달린 답변인지 알기위해 Foreign Key 설정 //Board타입이기 때문에 알아서 Board테이블로 찾아감

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user; //누가 달은 댓글인지 알기위해 Foreign Key 설정 //User타입이기 때문에 알아서 User테이블로 찾아감

    @CreationTimestamp
    private Timestamp createDate;


}
