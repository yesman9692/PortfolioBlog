package wonseok.yang.portfolioblog.test;

import lombok.*;

//@Getter
//@Setter
@Data //Getter & Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id; //DB에서 들고온 값으로 고정이기 때문에 Final로 지정.
    private String username; //만약 변경할 일이 있다면 Final로 하면 안되겠죠.
    private String password;
    private String email;

    @Builder//생성자 호출 시, 객체.builder().매개변수("").매개변수("")...build(); 해서 원하는 매개변수만 사용하여 호출가능
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}


