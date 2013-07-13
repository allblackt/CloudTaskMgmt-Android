/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-06-26 16:27:34 UTC)
 * on 2013-07-13 at 13:07:30 UTC 
 * Modify at your own risk.
 */

package com.google.api.services.clouduserendpoint.model;

/**
 * Model definition for CloudUser.
 * 
 * <p>
 * This is the Java data model class that specifies how to parse/serialize into
 * the JSON that is transmitted over HTTP when working with the . For a detailed
 * explanation see: <a
 * href="http://code.google.com/p/google-http-java-client/wiki/JSON"
 * >http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 * 
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class CloudUser extends com.google.api.client.json.GenericJson {

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.util.List<java.lang.String> deviceKeys;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String email;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	@com.google.api.client.json.JsonString
	private java.lang.Long id;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Boolean isAdmin;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Boolean isLoggedIn;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String logoutURL;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String name;

	/**
	 * @return value or {@code null} for none
	 */
	public java.util.List<java.lang.String> getDeviceKeys() {
		return deviceKeys;
	}

	/**
	 * @param deviceKeys
	 *            deviceKeys or {@code null} for none
	 */
	public CloudUser setDeviceKeys(java.util.List<java.lang.String> deviceKeys) {
		this.deviceKeys = deviceKeys;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            email or {@code null} for none
	 */
	public CloudUser setEmail(java.lang.String email) {
		this.email = email;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            id or {@code null} for none
	 */
	public CloudUser setId(java.lang.Long id) {
		this.id = id;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Boolean getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            isAdmin or {@code null} for none
	 */
	public CloudUser setIsAdmin(java.lang.Boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	/**
	 * @param isLoggedIn
	 *            isLoggedIn or {@code null} for none
	 */
	public CloudUser setIsLoggedIn(java.lang.Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getLogoutURL() {
		return logoutURL;
	}

	/**
	 * @param logoutURL
	 *            logoutURL or {@code null} for none
	 */
	public CloudUser setLogoutURL(java.lang.String logoutURL) {
		this.logoutURL = logoutURL;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @param name
	 *            name or {@code null} for none
	 */
	public CloudUser setName(java.lang.String name) {
		this.name = name;
		return this;
	}

	@Override
	public CloudUser set(String fieldName, Object value) {
		return (CloudUser) super.set(fieldName, value);
	}

	@Override
	public CloudUser clone() {
		return (CloudUser) super.clone();
	}

	@Override
	public String toString() {
		return "CloudUser [email=" + email + ", id=" + id + "]";
	}
}
