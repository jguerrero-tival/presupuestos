package com.presupuestar.model.feedback;

import java.util.List;

public interface Rankeable {

	List<Feedback> getFeedbacks();

	float getAverageScore();

}
