package com.presupuestar.db.dao.impl;

import com.presupuestar.db.dao.FeedbackDAO;
import com.presupuestar.model.feedback.Feedback;

public class FeedbackDAOImpl extends AbstractHibernateDAO<Feedback> implements
		FeedbackDAO {

	public FeedbackDAOImpl() {
		super(Feedback.class);
	}

}
