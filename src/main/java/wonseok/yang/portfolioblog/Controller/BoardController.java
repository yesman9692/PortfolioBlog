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

    @GetMapping("jobBoard/{id}")
    public String findByIDj(@PathVariable int id, Model model) {
        model.addAttribute("jobBoard", boardService.jobBoardDetail(id));
        return "board/jobBoardDetail";
    }

    @GetMapping("socialBoard/{id}")
    public String findByIDs(@PathVariable int id, Model model) {
        model.addAttribute("jobBoard", boardService.socialBoardDetail(id));
        return "board/socialBoardDetail";
    }



    @GetMapping({"", "/"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/main")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/board/jobBoard")
    public String jobBoard(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("jobBoard", boardService.글목록j(pageable));
        return "/board/jobBoard";
    }

    @GetMapping("/board/socialBoard")
    public String socialBoard(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("socialBoard", boardService.글목록s(pageable));
        return "/board/socialBoard";
    }

    @GetMapping("/board/jobBoardWriteForm")
    public String jobBoardWriteForm(){
        return "/board/jobBoardWriteForm";
    }

    @GetMapping("/board/socialBoardWriteForm")
    public String socialBoardWriteForm(){
        return "/board/socialBoardWriteForm";
    }
}
