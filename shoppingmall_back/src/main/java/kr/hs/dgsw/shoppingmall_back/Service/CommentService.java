package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Comment;

import java.util.List;

public interface CommentService {

    Comment Create(Comment comment);
    List<Comment> GetCommentList(Long productId);
    boolean Delete(Long id);
}
