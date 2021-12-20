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

    //view
    @GetMapping({"", "/"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/main")
    public String main(Model model) {
        return "main";
    }



    //board detail
    @GetMapping("jobBoard/{id}")
    public String findByIDj(@PathVariable int id, Model model) {
        model.addAttribute("jobBoard", boardService.jobBoardDetail(id));
        return "board/jobBoardDetail";
    }

    @GetMapping("socialBoard/{id}")
    public String findByIDs(@PathVariable int id, Model model) {
        model.addAttribute("socialBoard", boardService.socialBoardDetail(id));
        return "board/socialBoardDetail";
    }

    @GetMapping("visitBoard/{id}")
    public String findByIDv(@PathVariable int id, Model model) {
        model.addAttribute("visitBoard", boardService.visitBoardDetail(id));
        return "board/visitBoardDetail";
    }


    //update
    @GetMapping("/jobBoard/updateForm/{id}")
    public String jobBoardUpdateForm(@PathVariable int id, Model model) {
        System.out.println("job update button click -> controller, ID:" + id);
        model.addAttribute("jobBoard", boardService.jobBoardDetail(id));
        System.out.println("job update button click -> controller -> Service. done");
        return "board/jobBoardUpdateForm";
    }

    @GetMapping("/socialBoard/updateForm/{id}")
    public String socialBoardUpdateForm(@PathVariable int id, Model model) {
        System.out.println("social update button click -> controller, ID:" + id);
        model.addAttribute("socialBoard", boardService.socialBoardDetail(id));
        System.out.println("social update button click -> controller -> Service. done");
        return "board/socialBoardUpdateForm";
    }

    @GetMapping("/visitBoard/updateForm/{id}")
    public String visitBoardUpdateForm(@PathVariable int id, Model model) {
        System.out.println("visit update button click -> controller, ID:" + id);
        model.addAttribute("visitBoard", boardService.visitBoardDetail(id));
        System.out.println("visit update button click -> controller -> Service. done");
        return "board/visitBoardUpdateForm";
    }



    //게시글 목록 불러오기
    @GetMapping("/board/jobBoard")
    public String jobBoard(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("jobBoard", boardService.글목록j(pageable));
        return "/board/jobBoard";
    }

    @GetMapping("/board/socialBoard")
    public String socialBoard(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("socialBoard", boardService.글목록s(pageable));
        return "/board/socialBoard";
    }

    @GetMapping("/board/visitBoard")
    public String visitBoard(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("visitBoard", boardService.글목록v(pageable));
        return "/board/visitBoard";
    }


    //글 쓰기 폼
    @GetMapping("/board/jobBoardWriteForm")
    public String jobBoardWriteForm(){
        return "/board/jobBoardWriteForm";
    }

    @GetMapping("/board/socialBoardWriteForm")
    public String socialBoardWriteForm(){
        return "/board/socialBoardWriteForm";
    }

    @GetMapping("/board/visitBoardWriteForm")
    public String visitBoardWriteForm(){
        return "/board/visitBoardWriteForm";
    }
}
