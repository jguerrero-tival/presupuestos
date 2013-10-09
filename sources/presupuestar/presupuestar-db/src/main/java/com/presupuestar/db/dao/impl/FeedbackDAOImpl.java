package com.presupuestar.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.presupuestar.db.dao.FeedbackDAO;
import com.presupuestar.model.feedback.Feedback;

@Repository
public class FeedbackDAOImpl extends AbstractHibernateDAO<Feedback> implements
		FeedbackDAO {

	public FeedbackDAOImpl() {
		super(Feedback.class);
	}

}
