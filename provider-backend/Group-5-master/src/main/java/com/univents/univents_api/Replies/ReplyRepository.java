package com.univents.univents_api.Replies;

import com.univents.univents_api.Reviews.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    List<Reply> findByReview(Review review);
}
