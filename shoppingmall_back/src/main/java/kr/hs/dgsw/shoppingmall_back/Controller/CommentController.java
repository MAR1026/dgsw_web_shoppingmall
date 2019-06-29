package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.Comment;
import kr.hs.dgsw.shoppingmall_back.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/create")
    public Comment Create(@RequestBody Comment comment) {
        return this.commentService.Create(comment);
    }

    @GetMapping(value = "/findAll/{productId}")
    public List<Comment> findAllComment(@PathVariable Long productId) {
        return this.commentService.GetCommentList(productId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return this.commentService.Delete(id);
    }
}
