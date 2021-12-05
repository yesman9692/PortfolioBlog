package wonseok.yang.portfolioblog.model;
//테이블을 생성하기위한 모델들

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;



@Data //Getter & Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //생성자 호출 시, 객체.builder().매개변수("").매개변수("")...build(); 해서 원하는 매개변수만 사용하여 호출가능
@Entity //테이블화 시키는 어노테이션. 프로젝트가 실행될 때 이 클래스를 읽어서, 자동으로 MySQL에 테이블이 생성됨
//JPA(=ORM) -> Java 오브젝트를 Table로 매핑해주는 기술.
//@DynamicInsert //insert시 null값인 쿼리는 넣지않음.

public class User {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. 오라클=시퀀스 / MySQL=AutoIncrement
    private int id; //mysql: auto_increment

    @Column(nullable = false, length = 20, unique = true)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password;

    private String email;


    //@ColumnDefault("'user'")어노테이션 너무 덕지덕지 붙이면 좋지않으므로 다른 방법 강구
    @Enumerated(EnumType.STRING)//DB는 enum타입이 없으므로 설정해줘야 함
    private RoleType role;  //RoleType이라느 Enum을 만들어줌
                            //Enum을 쓰는게 좋다(Data의 도메인(범위)을 만들 수 있기 때문)

    @CreationTimestamp //시간이 자동으로 입력됨
    private Timestamp createDate;
}
