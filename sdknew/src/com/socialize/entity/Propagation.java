/*
 * Copyright (c) 2012 Socialize Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.socialize.entity;

import com.socialize.api.action.ShareType;
import com.socialize.networks.SocialNetwork;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jason Polites
 *
 */
public class Propagation implements Serializable {

	private static final long serialVersionUID = 7516996181091226449L;

	private Map<String, String> extraParams;
	private List<ShareType> thirdParties;
	
	public Propagation() {
		super();
		extraParams = new HashMap<String, String>();
		thirdParties = new LinkedList<ShareType>();
	}

	public Map<String, String> getExtraParams() {
		return extraParams;
	}

	public void setExtraParams(Map<String, String> extraParams) {
		this.extraParams = extraParams;
	}

	public List<ShareType> getThirdParties() {
		return thirdParties;
	}

	public void setThirdParties(List<ShareType> thirdParties) {
		this.thirdParties = thirdParties;
	}
	
	public void addExtraParam(String key, String value) {
		extraParams.put(key, value);
	}
	
	public void addThirdParty(SocialNetwork network) {
		thirdParties.add(ShareType.valueOf(network));
	}
	
	public void addThirdParty(ShareType network) {
		thirdParties.add(network);
	}
}