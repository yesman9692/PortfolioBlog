package wonseok.yang.portfolioblog.configuration.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wonseok.yang.portfolioblog.model.User;
import wonseok.yang.portfolioblog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //스프링이 로그인 요청을 가로챌 때, username, password를 가로채는데, password부분 처리는 알아서 함.
    //나는 username이 DB에 있는지만 확인하면 됨. 그걸 여기서 할 것.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username).orElseThrow(() -> {
            System.out.println("해당 사용자를 찾을 수 없습니다.:" + username);
            return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.:" + username);
        });
        System.out.println("세션 가져오기 성공:" + username);
        return new PrincipalDetail(principal); //시큐리티의 세션에 유저 정보가 저장됨. (UserDetails타입(=principal))
    }
}
