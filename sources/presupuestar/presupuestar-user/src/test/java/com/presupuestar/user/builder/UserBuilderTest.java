package com.presupuestar.user.builder;

import org.junit.Assert;
import org.junit.Test;

import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.ProffesionalType;
import com.presupuestar.model.user.User;
import com.presupuestar.model.user.profile.BasicProfile;
import com.presupuestar.model.user.profile.FullProfile;

public class UserBuilderTest {

	private static final String EMAIL = "sebastianlavie@gmail.com",
			PASSWORD = "password";
	private static final String FIRST_NAME = "Sebastian", LAST_NAME = "Lavie";
	private static final String REASON = "My Company S.A.";

	@Test
	public void buildPerson() {
		UserBuilder builder = UserBuilder.forPerson();
		builder.buildUserAccess(EMAIL, PASSWORD);
		builder.buildName(FIRST_NAME, LAST_NAME);
		User person = builder.getPerson();
		assertUser(person, Person.class);
		assertUserAccess(person);
		assertPersonProfile(person);
	}

	@Test(expected = ClassCastException.class)
	public void buildPersonFailGetProffesional() {
		UserBuilder.forPerson().getProffesional();
	}

	@Test(expected = ClassCastException.class)
	public void buildPersonFailGetCommerce() {
		UserBuilder.forPerson().getCommerce();
	}

	@Test
	public void buildProffesional() {
		UserBuilder builder = UserBuilder.forProffesional();
		builder.buildUserAccess(EMAIL, PASSWORD);
		builder.buildName(FIRST_NAME, LAST_NAME);
		builder.buildProffesionalType(ProffesionalType.SELF_EMPLOYED);
		builder.buildProffesion(new Proffesion());
		Proffesional proffesional = builder.getProffesional();
		assertUser(proffesional, Proffesional.class);
		assertUserAccess(proffesional);
		assertProffesionalProfile(proffesional);
		Assert.assertNotNull(proffesional.getType());
		Assert.assertEquals(ProffesionalType.SELF_EMPLOYED,
				proffesional.getType());
		Assert.assertNotNull(proffesional.getProffesion());
	}

	@Test(expected = ClassCastException.class)
	public void buildProffesionalFailGetPerson() {
		UserBuilder.forProffesional().getPerson();
	}

	@Test(expected = ClassCastException.class)
	public void buildProffesionalFailGetCommerce() {
		UserBuilder.forProffesional().getCommerce();
	}

	@Test
	public void buildCommerce() {
		UserBuilder builder = UserBuilder.forCommerce();
		builder.buildUserAccess(EMAIL, PASSWORD);
		builder.buildReason(REASON);
		User commerce = builder.getCommerce();
		assertUser(commerce, Commerce.class);
		assertUserAccess(commerce);
		assertCommerceProfile(commerce);
	}

	@Test(expected = ClassCastException.class)
	public void buildCommerceFailGetPerson() {
		UserBuilder.forCommerce().getPerson();
	}

	@Test(expected = ClassCastException.class)
	public void buildCommerceFailGetProffesional() {
		UserBuilder.forCommerce().getProffesional();
	}

	private void assertUser(User proffesional, Class<? extends User> userClass) {
		Assert.assertNotNull(proffesional);
		Assert.assertEquals(userClass, proffesional.getClass());
	}

	private void assertUserAccess(User user) {
		Assert.assertNotNull(user.getAccess());
		Assert.assertEquals(EMAIL, user.getAccess().getEmail());
		Assert.assertEquals(PASSWORD, user.getAccess().getPassword());
	}

	private void assertPersonProfile(User person) {
		Assert.assertNotNull(person.getProfile());
		Assert.assertEquals(BasicProfile.class, person.getProfile().getClass());
		BasicProfile profile = (BasicProfile) person.getProfile();
		Assert.assertEquals(FIRST_NAME, profile.getFirstName());
		Assert.assertEquals(LAST_NAME, profile.getLastName());
	}

	private void assertProffesionalProfile(User proffesional) {
		Assert.assertNotNull(proffesional.getProfile());
		Assert.assertEquals(FullProfile.class, proffesional.getProfile()
				.getClass());
		FullProfile profile = (FullProfile) proffesional.getProfile();
		Assert.assertEquals(FIRST_NAME, profile.getFirstName());
		Assert.assertEquals(LAST_NAME, profile.getLastName());
		Assert.assertNull(profile.getReason());
	}

	private void assertCommerceProfile(User commerce) {
		Assert.assertNotNull(commerce.getProfile());
		Assert.assertEquals(FullProfile.class, commerce.getProfile().getClass());
		FullProfile profile = (FullProfile) commerce.getProfile();
		Assert.assertEquals(REASON, profile.getReason());
		Assert.assertNull(profile.getFirstName());
		Assert.assertNull(profile.getLastName());
	}

}
