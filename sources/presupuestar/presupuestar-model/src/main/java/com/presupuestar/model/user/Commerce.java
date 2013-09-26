package com.presupuestar.model.user;

import java.util.List;

import com.presupuestar.model.budget.ProductsBudget;
import com.presupuestar.model.feedback.Feedback;
import com.presupuestar.model.feedback.Rankeable;
import com.presupuestar.model.user.profile.FullProfile;
import com.presupuestar.model.user.store.Store;

public class Commerce extends User implements Rankeable {

	private static final long serialVersionUID = 1L;

	private FullProfile profile;
	private Store store;
	private List<ProductsBudget> budgets;
	private List<Feedback> feedbacks;
	private float averageScore;

	public Commerce() {
		super();
	}

	public Commerce(UserAccess access) {
		super(access);
	}

	public FullProfile getProfile() {
		return profile;
	}

	public void setProfile(FullProfile profile) {
		this.profile = profile;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<ProductsBudget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<ProductsBudget> budgets) {
		this.budgets = budgets;
	}

	@Override
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}

}
