package com.presupuestar.user.service.fixture;

import uk.org.sith.sproing.fit.FixtureWirer;

public class PresupuestarUserFixtureWirer extends FixtureWirer {

	@Override
	public String[] getPaths() {
		return new String[] { "classpath:presupuestar-user.xml" };
	}

}
