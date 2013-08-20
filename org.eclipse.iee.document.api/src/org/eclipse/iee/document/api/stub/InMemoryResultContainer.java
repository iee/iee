package org.eclipse.iee.document.api.stub;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.document.api.IResultContainer;

public class InMemoryResultContainer implements IResultContainer {

	private Map<String, String> results = new HashMap<>();
	
	public InMemoryResultContainer() {
	}
	
	@Override
	public void putResult(String padId, String result) {
		results.put(padId, result);
	}

	@Override
	public String getResult(String padId) {
		return results.get(padId);
	}

}
