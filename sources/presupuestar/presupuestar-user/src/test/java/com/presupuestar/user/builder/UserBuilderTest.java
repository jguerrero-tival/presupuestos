package com.presupuestar.user.builder;

import org.junit.Assert;
import org.junit.Test;

import com.presupuestar.model.profession.Profession;
import com.presupuestar.model.user.Commerce;
import com.presupuestar.model.user.Person;
import com.presupuestar.model.user.Professional;
import com.presupuestar.model.user.ProfessionalType;
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
	public void buildPersonFailGetProfessional() {
		UserBuilder.forPerson().getProfessional();
	}

	@Test(expected = ClassCastException.class)
	public void buildPersonFailGetCommerce() {
		UserBuilder.forPerson().getCommerce();
	}

	@Test
	public void buildProfessional() {
		UserBuilder builder = UserBuilder.forProfessional();
		builder.buildUserAccess(EMAIL, PASSWORD);
		builder.buildName(FIRST_NAME, LAST_NAME);
		builder.buildProfessionalType(ProfessionalType.SELF_EMPLOYED);
		builder.buildProfession(new Profession());
		Professional professional = builder.getProfessional();
		assertUser(professional, Professional.class);
		assertUserAccess(professional);
		assertProfessionalProfile(professional);
		Assert.assertNotNull(professional.getType());
		Assert.assertEquals(ProfessionalType.SELF_EMPLOYED,
				professional.getType());
		Assert.assertNotNull(professional.getProfession());
	}

	@Test(expected = ClassCastException.class)
	public void buildProfessionalFailGetPerson() {
		UserBuilder.forProfessional().getPerson();
	}

	@Test(expected = ClassCastException.class)
	public void buildProfessionalFailGetCommerce() {
		UserBuilder.forProfessional().getCommerce();
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
	public void buildCommerceFailGetProfessional() {
		UserBuilder.forCommerce().getProfessional();
	}

	private void assertUser(User professional, Class<? extends User> userClass) {
		Assert.assertNotNull(professional);
		Assert.assertEquals(userClass, professional.getClass());
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

	private void assertProfessionalProfile(User professional) {
		Assert.assertNotNull(professional.getProfile());
		Assert.assertEquals(FullProfile.class, professional.getProfile()
				.getClass());
		FullProfile profile = (FullProfile) professional.getProfile();
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
