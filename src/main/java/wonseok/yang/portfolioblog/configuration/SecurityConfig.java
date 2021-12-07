package wonseok.yang.portfolioblog.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import wonseok.yang.portfolioblog.configuration.auth.PrincipalDetailService;

import java.security.Principal;

/*이 3개의 어노테이션은 세트다.*/
@Configuration //빈 등록
@EnableWebSecurity //시큐리티 필터가 등록이 된다. 그 설정을 여기서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근하면 권한 및 인증을 미리 체크하겠다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean //IoC가 된다
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    //시큐리티가 대신 로그인 해주는데, password를 가로채기 하는데
    //해당 pwd가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
    //같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeHttpRequests()
            .antMatchers("**") //auth/~주소로 들어온 요청들은
            .permitAll() //모두 접근 가능
            .anyRequest() //아닌 요청은
            .authenticated() //auth가 필요함
          .and()
            .formLogin() //로그인 폼으로 연결시켜줌
            .loginPage("/auth/loginForm")//로그인 폼 주소
            .loginProcessingUrl("/auth/loginProc") //스피링 시큐리티가 해당 주소로 들어오는 요청을 가로채서 대신 로그인 해줌
            .defaultSuccessUrl("/") //로그인 성공하면 리턴되는 url
        ;
    }
}

