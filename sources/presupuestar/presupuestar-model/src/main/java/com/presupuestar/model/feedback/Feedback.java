package com.presupuestar.model.feedback;

import java.util.List;

import com.presupuestar.model.DomainObject;

public class Feedback extends DomainObject {

	private static final long serialVersionUID = 1L;

	private FeedbackType type;
	private Rankeable feedbackOn;
	private List<Comment> comments;
	private int score;

	public Feedback() {
		super();
	}

	public FeedbackType getType() {
		return type;
	}

	public void setType(FeedbackType type) {
		this.type = type;
	}

	public Rankeable getFeedbackOn() {
		return feedbackOn;
	}

	public void setFeedbackOn(Rankeable feedbackOn) {
		this.feedbackOn = feedbackOn;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
