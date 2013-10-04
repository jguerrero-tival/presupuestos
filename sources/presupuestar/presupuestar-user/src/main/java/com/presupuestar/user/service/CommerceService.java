package com.presupuestar.user.service;

import com.presupuestar.model.user.Commerce;
import com.presupuestar.user.exception.InvalidEmailFormatException;

public interface CommerceService {

	Commerce registerNewCommerceAccount(String email, String password,
			String reason) throws InvalidEmailFormatException;

	Commerce userLogin(String email, String password);

}
