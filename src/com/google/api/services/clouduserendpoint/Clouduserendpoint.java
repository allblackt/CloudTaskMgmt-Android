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

package com.google.api.services.clouduserendpoint;

/**
 * Service definition for Clouduserendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link ClouduserendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Clouduserendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.15.0-rc of the  library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://ctm-tudor.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "clouduserendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Clouduserendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Clouduserendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getCloudUser".
   *
   * This request holds the parameters needed by the the clouduserendpoint server.  After setting any
   * optional parameters, call the {@link GetCloudUser#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetCloudUser getCloudUser(java.lang.Long id) throws java.io.IOException {
    GetCloudUser result = new GetCloudUser(id);
    initialize(result);
    return result;
  }

  public class GetCloudUser extends ClouduserendpointRequest<com.google.api.services.clouduserendpoint.model.CloudUser> {

    private static final String REST_PATH = "clouduser/{id}";

    /**
     * Create a request for the method "getCloudUser".
     *
     * This request holds the parameters needed by the the clouduserendpoint server.  After setting
     * any optional parameters, call the {@link GetCloudUser#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetCloudUser#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetCloudUser(java.lang.Long id) {
      super(Clouduserendpoint.this, "GET", REST_PATH, null, com.google.api.services.clouduserendpoint.model.CloudUser.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetCloudUser setAlt(java.lang.String alt) {
      return (GetCloudUser) super.setAlt(alt);
    }

    @Override
    public GetCloudUser setFields(java.lang.String fields) {
      return (GetCloudUser) super.setFields(fields);
    }

    @Override
    public GetCloudUser setKey(java.lang.String key) {
      return (GetCloudUser) super.setKey(key);
    }

    @Override
    public GetCloudUser setOauthToken(java.lang.String oauthToken) {
      return (GetCloudUser) super.setOauthToken(oauthToken);
    }

    @Override
    public GetCloudUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetCloudUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetCloudUser setQuotaUser(java.lang.String quotaUser) {
      return (GetCloudUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetCloudUser setUserIp(java.lang.String userIp) {
      return (GetCloudUser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetCloudUser setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetCloudUser set(String parameterName, Object value) {
      return (GetCloudUser) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getCloudUserByEmail".
   *
   * This request holds the parameters needed by the the clouduserendpoint server.  After setting any
   * optional parameters, call the {@link GetCloudUserByEmail#execute()} method to invoke the remote
   * operation.
   *
   * @param email
   * @return the request
   */
  public GetCloudUserByEmail getCloudUserByEmail(java.lang.String email) throws java.io.IOException {
    GetCloudUserByEmail result = new GetCloudUserByEmail(email);
    initialize(result);
    return result;
  }

  public class GetCloudUserByEmail extends ClouduserendpointRequest<com.google.api.services.clouduserendpoint.model.CloudUser> {

    private static final String REST_PATH = "clouduserbyemail";

    /**
     * Create a request for the method "getCloudUserByEmail".
     *
     * This request holds the parameters needed by the the clouduserendpoint server.  After setting
     * any optional parameters, call the {@link GetCloudUserByEmail#execute()} method to invoke the
     * remote operation. <p> {@link GetCloudUserByEmail#initialize(com.google.api.client.googleapis.se
     * rvices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param email
     * @since 1.13
     */
    protected GetCloudUserByEmail(java.lang.String email) {
      super(Clouduserendpoint.this, "GET", REST_PATH, null, com.google.api.services.clouduserendpoint.model.CloudUser.class);
      this.email = com.google.api.client.util.Preconditions.checkNotNull(email, "Required parameter email must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetCloudUserByEmail setAlt(java.lang.String alt) {
      return (GetCloudUserByEmail) super.setAlt(alt);
    }

    @Override
    public GetCloudUserByEmail setFields(java.lang.String fields) {
      return (GetCloudUserByEmail) super.setFields(fields);
    }

    @Override
    public GetCloudUserByEmail setKey(java.lang.String key) {
      return (GetCloudUserByEmail) super.setKey(key);
    }

    @Override
    public GetCloudUserByEmail setOauthToken(java.lang.String oauthToken) {
      return (GetCloudUserByEmail) super.setOauthToken(oauthToken);
    }

    @Override
    public GetCloudUserByEmail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetCloudUserByEmail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetCloudUserByEmail setQuotaUser(java.lang.String quotaUser) {
      return (GetCloudUserByEmail) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetCloudUserByEmail setUserIp(java.lang.String userIp) {
      return (GetCloudUserByEmail) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String email;

    /**

     */
    public java.lang.String getEmail() {
      return email;
    }

    public GetCloudUserByEmail setEmail(java.lang.String email) {
      this.email = email;
      return this;
    }

    @Override
    public GetCloudUserByEmail set(String parameterName, Object value) {
      return (GetCloudUserByEmail) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getallusers".
   *
   * This request holds the parameters needed by the the clouduserendpoint server.  After setting any
   * optional parameters, call the {@link Getallusers#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public Getallusers getallusers() throws java.io.IOException {
    Getallusers result = new Getallusers();
    initialize(result);
    return result;
  }

  public class Getallusers extends ClouduserendpointRequest<com.google.api.services.clouduserendpoint.model.CloudUserCollection> {

    private static final String REST_PATH = "getallusers";

    /**
     * Create a request for the method "getallusers".
     *
     * This request holds the parameters needed by the the clouduserendpoint server.  After setting
     * any optional parameters, call the {@link Getallusers#execute()} method to invoke the remote
     * operation. <p> {@link
     * Getallusers#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected Getallusers() {
      super(Clouduserendpoint.this, "GET", REST_PATH, null, com.google.api.services.clouduserendpoint.model.CloudUserCollection.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public Getallusers setAlt(java.lang.String alt) {
      return (Getallusers) super.setAlt(alt);
    }

    @Override
    public Getallusers setFields(java.lang.String fields) {
      return (Getallusers) super.setFields(fields);
    }

    @Override
    public Getallusers setKey(java.lang.String key) {
      return (Getallusers) super.setKey(key);
    }

    @Override
    public Getallusers setOauthToken(java.lang.String oauthToken) {
      return (Getallusers) super.setOauthToken(oauthToken);
    }

    @Override
    public Getallusers setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Getallusers) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Getallusers setQuotaUser(java.lang.String quotaUser) {
      return (Getallusers) super.setQuotaUser(quotaUser);
    }

    @Override
    public Getallusers setUserIp(java.lang.String userIp) {
      return (Getallusers) super.setUserIp(userIp);
    }

    @Override
    public Getallusers set(String parameterName, Object value) {
      return (Getallusers) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertCloudUser".
   *
   * This request holds the parameters needed by the the clouduserendpoint server.  After setting any
   * optional parameters, call the {@link InsertCloudUser#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.google.api.services.clouduserendpoint.model.CloudUser}
   * @return the request
   */
  public InsertCloudUser insertCloudUser(com.google.api.services.clouduserendpoint.model.CloudUser content) throws java.io.IOException {
    InsertCloudUser result = new InsertCloudUser(content);
    initialize(result);
    return result;
  }

  public class InsertCloudUser extends ClouduserendpointRequest<com.google.api.services.clouduserendpoint.model.CloudUser> {

    private static final String REST_PATH = "insertclouduser";

    /**
     * Create a request for the method "insertCloudUser".
     *
     * This request holds the parameters needed by the the clouduserendpoint server.  After setting
     * any optional parameters, call the {@link InsertCloudUser#execute()} method to invoke the remote
     * operation. <p> {@link InsertCloudUser#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.google.api.services.clouduserendpoint.model.CloudUser}
     * @since 1.13
     */
    protected InsertCloudUser(com.google.api.services.clouduserendpoint.model.CloudUser content) {
      super(Clouduserendpoint.this, "POST", REST_PATH, content, com.google.api.services.clouduserendpoint.model.CloudUser.class);
    }

    @Override
    public InsertCloudUser setAlt(java.lang.String alt) {
      return (InsertCloudUser) super.setAlt(alt);
    }

    @Override
    public InsertCloudUser setFields(java.lang.String fields) {
      return (InsertCloudUser) super.setFields(fields);
    }

    @Override
    public InsertCloudUser setKey(java.lang.String key) {
      return (InsertCloudUser) super.setKey(key);
    }

    @Override
    public InsertCloudUser setOauthToken(java.lang.String oauthToken) {
      return (InsertCloudUser) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertCloudUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertCloudUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertCloudUser setQuotaUser(java.lang.String quotaUser) {
      return (InsertCloudUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertCloudUser setUserIp(java.lang.String userIp) {
      return (InsertCloudUser) super.setUserIp(userIp);
    }

    @Override
    public InsertCloudUser set(String parameterName, Object value) {
      return (InsertCloudUser) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listCloudUser".
   *
   * This request holds the parameters needed by the the clouduserendpoint server.  After setting any
   * optional parameters, call the {@link ListCloudUser#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListCloudUser listCloudUser() throws java.io.IOException {
    ListCloudUser result = new ListCloudUser();
    initialize(result);
    return result;
  }

  public class ListCloudUser extends ClouduserendpointRequest<com.google.api.services.clouduserendpoint.model.CollectionResponseCloudUser> {

    private static final String REST_PATH = "clouduser";

    /**
     * Create a request for the method "listCloudUser".
     *
     * This request holds the parameters needed by the the clouduserendpoint server.  After setting
     * any optional parameters, call the {@link ListCloudUser#execute()} method to invoke the remote
     * operation. <p> {@link ListCloudUser#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListCloudUser() {
      super(Clouduserendpoint.this, "GET", REST_PATH, null, com.google.api.services.clouduserendpoint.model.CollectionResponseCloudUser.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListCloudUser setAlt(java.lang.String alt) {
      return (ListCloudUser) super.setAlt(alt);
    }

    @Override
    public ListCloudUser setFields(java.lang.String fields) {
      return (ListCloudUser) super.setFields(fields);
    }

    @Override
    public ListCloudUser setKey(java.lang.String key) {
      return (ListCloudUser) super.setKey(key);
    }

    @Override
    public ListCloudUser setOauthToken(java.lang.String oauthToken) {
      return (ListCloudUser) super.setOauthToken(oauthToken);
    }

    @Override
    public ListCloudUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListCloudUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListCloudUser setQuotaUser(java.lang.String quotaUser) {
      return (ListCloudUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListCloudUser setUserIp(java.lang.String userIp) {
      return (ListCloudUser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListCloudUser setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListCloudUser setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListCloudUser set(String parameterName, Object value) {
      return (ListCloudUser) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "registerdeviceforuser".
   *
   * This request holds the parameters needed by the the clouduserendpoint server.  After setting any
   * optional parameters, call the {@link Registerdeviceforuser#execute()} method to invoke the remote
   * operation.
   *
   * @param deviceKey
   * @param email
   * @return the request
   */
  public Registerdeviceforuser registerdeviceforuser(java.lang.String deviceKey, java.lang.String email) throws java.io.IOException {
    Registerdeviceforuser result = new Registerdeviceforuser(deviceKey, email);
    initialize(result);
    return result;
  }

  public class Registerdeviceforuser extends ClouduserendpointRequest<com.google.api.services.clouduserendpoint.model.JsonMap> {

    private static final String REST_PATH = "registerdeviceforuser";

    /**
     * Create a request for the method "registerdeviceforuser".
     *
     * This request holds the parameters needed by the the clouduserendpoint server.  After setting
     * any optional parameters, call the {@link Registerdeviceforuser#execute()} method to invoke the
     * remote operation. <p> {@link Registerdeviceforuser#initialize(com.google.api.client.googleapis.
     * services.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param deviceKey
     * @param email
     * @since 1.13
     */
    protected Registerdeviceforuser(java.lang.String deviceKey, java.lang.String email) {
      super(Clouduserendpoint.this, "POST", REST_PATH, null, com.google.api.services.clouduserendpoint.model.JsonMap.class);
      this.deviceKey = com.google.api.client.util.Preconditions.checkNotNull(deviceKey, "Required parameter deviceKey must be specified.");
      this.email = com.google.api.client.util.Preconditions.checkNotNull(email, "Required parameter email must be specified.");
    }

    @Override
    public Registerdeviceforuser setAlt(java.lang.String alt) {
      return (Registerdeviceforuser) super.setAlt(alt);
    }

    @Override
    public Registerdeviceforuser setFields(java.lang.String fields) {
      return (Registerdeviceforuser) super.setFields(fields);
    }

    @Override
    public Registerdeviceforuser setKey(java.lang.String key) {
      return (Registerdeviceforuser) super.setKey(key);
    }

    @Override
    public Registerdeviceforuser setOauthToken(java.lang.String oauthToken) {
      return (Registerdeviceforuser) super.setOauthToken(oauthToken);
    }

    @Override
    public Registerdeviceforuser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Registerdeviceforuser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Registerdeviceforuser setQuotaUser(java.lang.String quotaUser) {
      return (Registerdeviceforuser) super.setQuotaUser(quotaUser);
    }

    @Override
    public Registerdeviceforuser setUserIp(java.lang.String userIp) {
      return (Registerdeviceforuser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String deviceKey;

    /**

     */
    public java.lang.String getDeviceKey() {
      return deviceKey;
    }

    public Registerdeviceforuser setDeviceKey(java.lang.String deviceKey) {
      this.deviceKey = deviceKey;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String email;

    /**

     */
    public java.lang.String getEmail() {
      return email;
    }

    public Registerdeviceforuser setEmail(java.lang.String email) {
      this.email = email;
      return this;
    }

    @Override
    public Registerdeviceforuser set(String parameterName, Object value) {
      return (Registerdeviceforuser) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateCloudUser".
   *
   * This request holds the parameters needed by the the clouduserendpoint server.  After setting any
   * optional parameters, call the {@link UpdateCloudUser#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.google.api.services.clouduserendpoint.model.CloudUser}
   * @return the request
   */
  public UpdateCloudUser updateCloudUser(com.google.api.services.clouduserendpoint.model.CloudUser content) throws java.io.IOException {
    UpdateCloudUser result = new UpdateCloudUser(content);
    initialize(result);
    return result;
  }

  public class UpdateCloudUser extends ClouduserendpointRequest<com.google.api.services.clouduserendpoint.model.CloudUser> {

    private static final String REST_PATH = "clouduser";

    /**
     * Create a request for the method "updateCloudUser".
     *
     * This request holds the parameters needed by the the clouduserendpoint server.  After setting
     * any optional parameters, call the {@link UpdateCloudUser#execute()} method to invoke the remote
     * operation. <p> {@link UpdateCloudUser#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.google.api.services.clouduserendpoint.model.CloudUser}
     * @since 1.13
     */
    protected UpdateCloudUser(com.google.api.services.clouduserendpoint.model.CloudUser content) {
      super(Clouduserendpoint.this, "PUT", REST_PATH, content, com.google.api.services.clouduserendpoint.model.CloudUser.class);
    }

    @Override
    public UpdateCloudUser setAlt(java.lang.String alt) {
      return (UpdateCloudUser) super.setAlt(alt);
    }

    @Override
    public UpdateCloudUser setFields(java.lang.String fields) {
      return (UpdateCloudUser) super.setFields(fields);
    }

    @Override
    public UpdateCloudUser setKey(java.lang.String key) {
      return (UpdateCloudUser) super.setKey(key);
    }

    @Override
    public UpdateCloudUser setOauthToken(java.lang.String oauthToken) {
      return (UpdateCloudUser) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateCloudUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateCloudUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateCloudUser setQuotaUser(java.lang.String quotaUser) {
      return (UpdateCloudUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateCloudUser setUserIp(java.lang.String userIp) {
      return (UpdateCloudUser) super.setUserIp(userIp);
    }

    @Override
    public UpdateCloudUser set(String parameterName, Object value) {
      return (UpdateCloudUser) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Clouduserendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Clouduserendpoint}. */
    @Override
    public Clouduserendpoint build() {
      return new Clouduserendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link ClouduserendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setClouduserendpointRequestInitializer(
        ClouduserendpointRequestInitializer clouduserendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(clouduserendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}