package com.presupuestar.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.feedback.Comment;
import com.presupuestar.model.feedback.Feedback;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-presupuestar-db.xml" })
@Transactional
public class FeedbackDAOTest {

	@Test
	public void getAllFeedbacks() {
		FeedbackDAO feedbackDAO = (FeedbackDAO) DAOLocator.getInstance()
				.getDao(FeedbackDAO.class);
		List<Feedback> feedbacks = feedbackDAO.getAll();
		Assert.assertNotNull(feedbacks);
		for (Feedback feedback : feedbacks) {
			Assert.assertNotNull(feedback);
			Assert.assertNotNull(feedback.getFeedbackOn());
			Assert.assertNotNull(feedback.getComments());
			for (Comment comment : feedback.getComments()) {
				Assert.assertNotNull(comment);
				Assert.assertNotNull(comment.getAuthor());
			}
		}
	}

}
