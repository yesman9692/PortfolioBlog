package wonseok.yang.portfolioblog.configuration.auth;

import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import wonseok.yang.portfolioblog.model.User;

import java.util.ArrayList;
import java.util.Collection;

//스프링 시큐리티가 로그인 요청을 가로채서 로그인진행, 완료되면
//UserDetails 타입의 오브젝트를 세션 저장소에 저장.
//(여기에선 UserDetails를 상속받은 PrincipalDetails)
@Getter
public class PrincipalDetail implements UserDetails {
    private User user; //개체를 품고있음. 콤포지션. //상속과 비슷한 개념

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }


    @Override
    public boolean isAccountNonExpired() { //계정이 만료되지 않았는지
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정이 잠겨있지 않은지
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호 만료되지 않았는지
        return true;
    }

    @Override
    public boolean isEnabled() { //계정이 활성화 되어있는지
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //계정의 권한
        Collection<GrantedAuthority> colletors = new ArrayList<>();
        colletors.add(()-> {return "ROLE_" + user.getRole();});

        return null;
    }
}
