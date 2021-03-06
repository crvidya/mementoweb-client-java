package dev.memento;

/*
 * #%L
 * MementoWeb Java Client Stubs
 * %%
 * Copyright (C) 2012 - 2013 The British Library
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.Serializable;

public class Memento implements Comparable<Memento>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String mUrl;
	private String mRel;
	private SimpleDateTime mDatetime;
	
	
	public Memento(Link link) {
		mUrl = link.getUrl();
		mRel = link.getRel();
		mDatetime = link.getDatetime();	
	}

	public String getUrl() {
		return mUrl;
	}
	
	public void setUrl(String url) {
		this.mUrl = url;
	}
	
	public String getRel() {
		return mRel;
	}
	
	public void setRel(String rel) {
		this.mRel = rel;
	}
	
	public SimpleDateTime getDateTime() {
		return mDatetime;
	}
	
	public String getDateTimeString() {
		return mDatetime.longDateFormatted();
	}
	
	public void setDateTime(String datetime) {
		mDatetime = new SimpleDateTime(datetime);
	}
	
	public CharSequence getDateAndTimeFormatted() {		
		return mDatetime.dateAndTimeFormatted();
	}
	
	public String getDateTimeSimple() {
		return mDatetime.dateFormatted().toString();
	}
	
	@Override
	public String toString() {
		return "Memento: url=[" + mUrl + "] rel=[" + mRel + "]" + 
			" datetime=[" + mDatetime + "]";
	}

	@Override
	public int compareTo(Memento memento) {			
		return mDatetime.compareTo(memento.mDatetime);
	}    	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mDatetime == null) ? 0 : mDatetime.hashCode());
		result = prime * result + ((mRel == null) ? 0 : mRel.hashCode());
		result = prime * result + ((mUrl == null) ? 0 : mUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Memento other = (Memento) obj;
		if (mDatetime == null) {
			if (other.mDatetime != null)
				return false;
		} else if (!mDatetime.equals(other.mDatetime))
			return false;
		if (mRel == null) {
			if (other.mRel != null)
				return false;
		} else if (!mRel.equals(other.mRel))
			return false;
		if (mUrl == null) {
			if (other.mUrl != null)
				return false;
		} else if (!mUrl.equals(other.mUrl))
			return false;
		return true;
	}
}
