package com.presupuestar.model.user;

import java.util.List;

import com.presupuestar.model.budget.LaborBudget;
import com.presupuestar.model.feedback.Feedback;
import com.presupuestar.model.feedback.Rankeable;
import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.profile.FullProfile;

public class Professional extends User implements Rankeable {

	private static final long serialVersionUID = 1L;

	private FullProfile profile;
	private ProfessionalType type;
	private Profession profession;
	private List<LaborBudget> budgets;
	private List<Feedback> feedbacks;
	private float averageScore;

	public Professional() {
		super();
	}

	public Professional(UserAccess access) {
		super(access);
	}

	public FullProfile getProfile() {
		return profile;
	}

	public void setProfile(FullProfile profile) {
		this.profile = profile;
	}

	public ProfessionalType getType() {
		return type;
	}

	public void setType(ProfessionalType type) {
		this.type = type;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public List<LaborBudget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<LaborBudget> budgets) {
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
