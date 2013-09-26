package com.presupuestar.user.builder;

import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.ProffesionalType;
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

	public static UserBuilder forProffesional() {
		Proffesional proffesional = new Proffesional();
		proffesional.setProfile(new FullProfile());
		UserBuilder builder = new UserBuilder(proffesional);
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
		((Commerce) user).getProfile().setReason(reason);
	}

	public void buildProffesionalType(ProffesionalType type) {
		((Proffesional) user).setType(type);
	}

	public void buildProffesion(Proffesion proffesion) {
		((Proffesional) user).setProffesion(proffesion);
	}

	public Person getPerson() {
		return (Person) user;
	}

	public Proffesional getProffesional() {
		return (Proffesional) user;
	}

	public Commerce getCommerce() {
		return (Commerce) user;
	}

}