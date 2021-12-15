package wonseok.yang.portfolioblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wonseok.yang.portfolioblog.service.BoardService;

@Controller
public class BoardController { //컨트롤러

    @Autowired
    private BoardService boardService;

    @GetMapping("board/{id}")
    public String findByID(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/detail";
    }



    @GetMapping({"", "/"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/board/jobBoard")
    public String jobBoard(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.글목록(pageable));
        return "/board/jobBoard";
    }

    @GetMapping("/board/socialBoard")
    public String socialBoard(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.글목록(pageable));
        return "/board/socialBoard";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
