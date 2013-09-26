package com.presupuestar.model.budget;

import java.util.List;

import com.presupuestar.model.DomainObject;
import com.presupuestar.model.feedback.Feedback;
import com.presupuestar.model.feedback.Rankeable;

public class Budget extends DomainObject implements Rankeable {

	private static final long serialVersionUID = 1L;

	private double amount;
	private LaborBudget laborBudget;
	private ProductsBudget productBudget;
	private List<Feedback> feedbacks;
	private float averageScore;

	public Budget() {
		super();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LaborBudget getLaborBudget() {
		return laborBudget;
	}

	public void setLaborBudget(LaborBudget laborBudget) {
		this.laborBudget = laborBudget;
	}

	public ProductsBudget getProductBudget() {
		return productBudget;
	}

	public void setProductBudget(ProductsBudget productBudget) {
		this.productBudget = productBudget;
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
