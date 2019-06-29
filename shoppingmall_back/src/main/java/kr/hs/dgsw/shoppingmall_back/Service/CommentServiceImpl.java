package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Comment;
import kr.hs.dgsw.shoppingmall_back.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment Create(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public List<Comment> GetCommentList(Long productId) {
        Optional<List<Comment>> found = this.commentRepository.findByProductId(productId);

        if(found.isPresent()) {
            return found.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean Delete(Long id) {
        Optional<Comment> found = this.commentRepository.findById(id);

        if(found != null) {
            this.commentRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
