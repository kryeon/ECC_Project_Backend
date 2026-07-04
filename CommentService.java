package com.example.firstproject.service;

import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional(readOnly = true)
    public List<Comment> comments(Long articleId) {
        return commentRepository.findByArticleId(articleId);
    }

    @Transactional
    public Comment create(Long articleId, Comment dto) {
        return commentRepository.save(dto);
    }
}
