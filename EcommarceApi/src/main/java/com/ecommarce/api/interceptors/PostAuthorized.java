package com.ecommarce.api.interceptors;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PostInvocationAttribute;
import org.springframework.security.access.prepost.PostInvocationAuthorizationAdvice;
import org.springframework.security.core.Authentication;

public class PostAuthorized  implements PostInvocationAuthorizationAdvice{

	@Override
	public Object after(Authentication authentication, MethodInvocation mi, PostInvocationAttribute pia,
			Object returnedObject) throws AccessDeniedException {
		// TODO Auto-generated method stub
		return null;
	}

}
