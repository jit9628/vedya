package com.ecommarce.api.interceptors;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.prepost.PreInvocationAttribute;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdvice;
import org.springframework.security.core.Authentication;

public class PreAuthorized implements PreInvocationAuthorizationAdvice{

	@Override
	public boolean before(Authentication authentication, MethodInvocation mi,
			PreInvocationAttribute preInvocationAttribute) {
		// TODO Auto-generated method stub
		return false;
	}

}
