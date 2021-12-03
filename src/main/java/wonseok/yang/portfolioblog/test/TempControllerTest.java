package wonseok.yang.portfolioblog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String home() {
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String img() {
        return "/a.png";
    }

    @GetMapping("/temp/jsp")
    public String jsp() {
        return "test";
    }
}
