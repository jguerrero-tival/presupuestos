package com.presupuestar.model.feedback;

import java.util.Date;

import com.presupuestar.model.DomainObject;
import com.presupuestar.model.user.User;

public class Comment extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private String comment;
	private Date commentDate;
	private User author;
	
	public Comment() {
		super();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
