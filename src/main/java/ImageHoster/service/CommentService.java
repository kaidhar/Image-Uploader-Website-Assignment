package ImageHoster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentsRepository;

@Service
public class CommentService {

	@Autowired
	private CommentsRepository commentRepository;

	public List<Comment> getAllComments(int id) {
		return commentRepository.getAllComments(id);
	}

	public Comment createComment(Comment comment) {
		return commentRepository.createComment(comment);

	}
}
