package com.presupuestar.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.presupuestar.db.dao.ProffesionalDAO;
import com.presupuestar.db.dao.locator.DAOLocator;
import com.presupuestar.model.proffesion.Proffesion;
import com.presupuestar.model.user.Proffesional;
import com.presupuestar.model.user.ProffesionalType;
import com.presupuestar.user.builder.UserBuilder;
import com.presupuestar.user.service.ProffesionalService;

@Service
@Transactional
public class ProffesionalServiceImpl implements ProffesionalService {

	@Override
	public Proffesional registerNewProffesionalAccount(String email,
			String password, String firstName, String lastName,
			ProffesionalType type, Proffesion proffesion) {
		UserBuilder builder = UserBuilder.forProffesional();
		builder.buildUserAccess(email, password);
		builder.buildName(firstName, lastName);
		builder.buildProffesionalType(type);
		builder.buildProffesion(proffesion);
		Proffesional proffesional = builder.getProffesional();
		ProffesionalDAO proffesionalDao = (ProffesionalDAO) DAOLocator
				.getInstance().getDao(ProffesionalDAO.class);
		proffesionalDao.create(proffesional);
		return proffesional;
	}

}
