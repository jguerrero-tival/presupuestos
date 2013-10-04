package com.presupuestar.user.builder;

import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Professional;
import com.presupuestar.model.user.ProfessionalType;
import com.presupuestar.model.user.User;
import com.presupuestar.model.user.UserAccess;
import com.presupuestar.model.user.profile.BasicProfile;
import com.presupuestar.model.user.profile.FullProfile;

public class UserBuilder {

	private User user;

	private UserBuilder(User user) {
		super();
		this.user = user;
	}

	public static UserBuilder forPerson() {
		Person person = new Person();
		person.setProfile(new BasicProfile());
		UserBuilder builder = new UserBuilder(person);
		return builder;
	}

	public static UserBuilder forProfessional() {
		Professional professional = new Professional();
		professional.setProfile(new FullProfile());
		UserBuilder builder = new UserBuilder(professional);
		return builder;
	}

	public static UserBuilder forCommerce() {
		Commerce commerce = new Commerce();
		commerce.setProfile(new FullProfile());
		UserBuilder builder = new UserBuilder(commerce);
		return builder;
	}

	public void buildUserAccess(String email, String password) {
		UserAccess access = new UserAccess(email, password);
		user.setAccess(access);
	}

	public void buildName(String firstName, String lastName) {
		user.getProfile().setFirstName(firstName);
		user.getProfile().setLastName(lastName);
	}

	public void buildReason(String reason) {
		((FullProfile) user.getProfile()).setReason(reason);
	}

	public void buildProfessionalType(ProfessionalType type) {
		((Professional) user).setType(type);
	}

	public void buildProfession(Profession profession) {
		((Professional) user).setProfession(profession);
	}

	public Person getPerson() {
		return (Person) user;
	}

	public Professional getProfessional() {
		return (Professional) user;
	}

	public Commerce getCommerce() {
		return (Commerce) user;
	}

}