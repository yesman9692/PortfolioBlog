package wonseok.yang.portfolioblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootTest
class PortfolioBlogApplicationTests {

    @Test
    @GetMapping("test/hello")
    public String contextLoads() {
        return "hello spring boot";
    }

}
