package org.eclipse.iee.web;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.iee.document.api.IParameterProvider;

public class RequestParameterProvider implements IParameterProvider {

	private HttpServletRequest req;
	
	
	
	public RequestParameterProvider(HttpServletRequest req) {
		super();
		this.req = req;
	}

	@Override
	public String getParameterValue(String parameter) {
		return req.getParameter(parameter);
	}

}
