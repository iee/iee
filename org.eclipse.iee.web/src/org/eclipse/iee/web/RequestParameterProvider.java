package org.eclipse.iee.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.iee.document.api.IParameterProvider;

public class RequestParameterProvider implements IParameterProvider {

	private Map<String, String> params;
	
	public RequestParameterProvider(HttpServletRequest req) {
		super();
		Enumeration<String> parameterNames = req.getParameterNames();
		params = new HashMap<>();
		while (parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			params.put(nextElement, req.getParameter(nextElement));
		}
	}

	@Override
	public String getParameterValue(String parameter) {
		return params.get(parameter);
	}

}
