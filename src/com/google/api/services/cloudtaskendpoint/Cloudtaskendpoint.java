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
 * on 2013-07-13 at 13:19:47 UTC 
 * Modify at your own risk.
 */

package com.google.api.services.cloudtaskendpoint;

/**
 * Service definition for Cloudtaskendpoint (v1).
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
 * This service uses {@link CloudtaskendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Cloudtaskendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

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
  public static final String DEFAULT_SERVICE_PATH = "cloudtaskendpoint/v1/";

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
  public Cloudtaskendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Cloudtaskendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getcloudtask".
   *
   * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting any
   * optional parameters, call the {@link Getcloudtask#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public Getcloudtask getcloudtask(java.lang.Long id) throws java.io.IOException {
    Getcloudtask result = new Getcloudtask(id);
    initialize(result);
    return result;
  }

  public class Getcloudtask extends CloudtaskendpointRequest<com.google.api.services.cloudtaskendpoint.model.CloudTask> {

    private static final String REST_PATH = "getcloudtask";

    /**
     * Create a request for the method "getcloudtask".
     *
     * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting
     * any optional parameters, call the {@link Getcloudtask#execute()} method to invoke the remote
     * operation. <p> {@link
     * Getcloudtask#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected Getcloudtask(java.lang.Long id) {
      super(Cloudtaskendpoint.this, "GET", REST_PATH, null, com.google.api.services.cloudtaskendpoint.model.CloudTask.class);
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
    public Getcloudtask setAlt(java.lang.String alt) {
      return (Getcloudtask) super.setAlt(alt);
    }

    @Override
    public Getcloudtask setFields(java.lang.String fields) {
      return (Getcloudtask) super.setFields(fields);
    }

    @Override
    public Getcloudtask setKey(java.lang.String key) {
      return (Getcloudtask) super.setKey(key);
    }

    @Override
    public Getcloudtask setOauthToken(java.lang.String oauthToken) {
      return (Getcloudtask) super.setOauthToken(oauthToken);
    }

    @Override
    public Getcloudtask setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Getcloudtask) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Getcloudtask setQuotaUser(java.lang.String quotaUser) {
      return (Getcloudtask) super.setQuotaUser(quotaUser);
    }

    @Override
    public Getcloudtask setUserIp(java.lang.String userIp) {
      return (Getcloudtask) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public Getcloudtask setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public Getcloudtask set(String parameterName, Object value) {
      return (Getcloudtask) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getprojecttasks".
   *
   * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting any
   * optional parameters, call the {@link Getprojecttasks#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public Getprojecttasks getprojecttasks() throws java.io.IOException {
    Getprojecttasks result = new Getprojecttasks();
    initialize(result);
    return result;
  }

  public class Getprojecttasks extends CloudtaskendpointRequest<com.google.api.services.cloudtaskendpoint.model.CloudTaskCollection> {

    private static final String REST_PATH = "getprojecttasks";

    /**
     * Create a request for the method "getprojecttasks".
     *
     * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting
     * any optional parameters, call the {@link Getprojecttasks#execute()} method to invoke the remote
     * operation. <p> {@link Getprojecttasks#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected Getprojecttasks() {
      super(Cloudtaskendpoint.this, "GET", REST_PATH, null, com.google.api.services.cloudtaskendpoint.model.CloudTaskCollection.class);
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
    public Getprojecttasks setAlt(java.lang.String alt) {
      return (Getprojecttasks) super.setAlt(alt);
    }

    @Override
    public Getprojecttasks setFields(java.lang.String fields) {
      return (Getprojecttasks) super.setFields(fields);
    }

    @Override
    public Getprojecttasks setKey(java.lang.String key) {
      return (Getprojecttasks) super.setKey(key);
    }

    @Override
    public Getprojecttasks setOauthToken(java.lang.String oauthToken) {
      return (Getprojecttasks) super.setOauthToken(oauthToken);
    }

    @Override
    public Getprojecttasks setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Getprojecttasks) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Getprojecttasks setQuotaUser(java.lang.String quotaUser) {
      return (Getprojecttasks) super.setQuotaUser(quotaUser);
    }

    @Override
    public Getprojecttasks setUserIp(java.lang.String userIp) {
      return (Getprojecttasks) super.setUserIp(userIp);
    }

    @Override
    public Getprojecttasks set(String parameterName, Object value) {
      return (Getprojecttasks) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getusertasks".
   *
   * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting any
   * optional parameters, call the {@link Getusertasks#execute()} method to invoke the remote
   * operation.
   *
   * @param userid
   * @param projectid
   * @return the request
   */
  public Getusertasks getusertasks(java.lang.Long userid, java.lang.Long projectid) throws java.io.IOException {
    Getusertasks result = new Getusertasks(userid, projectid);
    initialize(result);
    return result;
  }

  public class Getusertasks extends CloudtaskendpointRequest<com.google.api.services.cloudtaskendpoint.model.CloudTaskCollection> {

    private static final String REST_PATH = "getusertasks/{userid}/{projectid}";

    /**
     * Create a request for the method "getusertasks".
     *
     * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting
     * any optional parameters, call the {@link Getusertasks#execute()} method to invoke the remote
     * operation. <p> {@link
     * Getusertasks#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param userid
     * @param projectid
     * @since 1.13
     */
    protected Getusertasks(java.lang.Long userid, java.lang.Long projectid) {
      super(Cloudtaskendpoint.this, "GET", REST_PATH, null, com.google.api.services.cloudtaskendpoint.model.CloudTaskCollection.class);
      this.userid = com.google.api.client.util.Preconditions.checkNotNull(userid, "Required parameter userid must be specified.");
      this.projectid = com.google.api.client.util.Preconditions.checkNotNull(projectid, "Required parameter projectid must be specified.");
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
    public Getusertasks setAlt(java.lang.String alt) {
      return (Getusertasks) super.setAlt(alt);
    }

    @Override
    public Getusertasks setFields(java.lang.String fields) {
      return (Getusertasks) super.setFields(fields);
    }

    @Override
    public Getusertasks setKey(java.lang.String key) {
      return (Getusertasks) super.setKey(key);
    }

    @Override
    public Getusertasks setOauthToken(java.lang.String oauthToken) {
      return (Getusertasks) super.setOauthToken(oauthToken);
    }

    @Override
    public Getusertasks setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Getusertasks) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Getusertasks setQuotaUser(java.lang.String quotaUser) {
      return (Getusertasks) super.setQuotaUser(quotaUser);
    }

    @Override
    public Getusertasks setUserIp(java.lang.String userIp) {
      return (Getusertasks) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long userid;

    /**

     */
    public java.lang.Long getUserid() {
      return userid;
    }

    public Getusertasks setUserid(java.lang.Long userid) {
      this.userid = userid;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Long projectid;

    /**

     */
    public java.lang.Long getProjectid() {
      return projectid;
    }

    public Getusertasks setProjectid(java.lang.Long projectid) {
      this.projectid = projectid;
      return this;
    }

    @Override
    public Getusertasks set(String parameterName, Object value) {
      return (Getusertasks) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertCloudTask".
   *
   * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting any
   * optional parameters, call the {@link InsertCloudTask#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.google.api.services.cloudtaskendpoint.model.CloudTask}
   * @return the request
   */
  public InsertCloudTask insertCloudTask(com.google.api.services.cloudtaskendpoint.model.CloudTask content) throws java.io.IOException {
    InsertCloudTask result = new InsertCloudTask(content);
    initialize(result);
    return result;
  }

  public class InsertCloudTask extends CloudtaskendpointRequest<com.google.api.services.cloudtaskendpoint.model.CloudTask> {

    private static final String REST_PATH = "insertcloudtask";

    /**
     * Create a request for the method "insertCloudTask".
     *
     * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting
     * any optional parameters, call the {@link InsertCloudTask#execute()} method to invoke the remote
     * operation. <p> {@link InsertCloudTask#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.google.api.services.cloudtaskendpoint.model.CloudTask}
     * @since 1.13
     */
    protected InsertCloudTask(com.google.api.services.cloudtaskendpoint.model.CloudTask content) {
      super(Cloudtaskendpoint.this, "POST", REST_PATH, content, com.google.api.services.cloudtaskendpoint.model.CloudTask.class);
    }

    @Override
    public InsertCloudTask setAlt(java.lang.String alt) {
      return (InsertCloudTask) super.setAlt(alt);
    }

    @Override
    public InsertCloudTask setFields(java.lang.String fields) {
      return (InsertCloudTask) super.setFields(fields);
    }

    @Override
    public InsertCloudTask setKey(java.lang.String key) {
      return (InsertCloudTask) super.setKey(key);
    }

    @Override
    public InsertCloudTask setOauthToken(java.lang.String oauthToken) {
      return (InsertCloudTask) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertCloudTask setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertCloudTask) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertCloudTask setQuotaUser(java.lang.String quotaUser) {
      return (InsertCloudTask) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertCloudTask setUserIp(java.lang.String userIp) {
      return (InsertCloudTask) super.setUserIp(userIp);
    }

    @Override
    public InsertCloudTask set(String parameterName, Object value) {
      return (InsertCloudTask) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listcloudtasks".
   *
   * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting any
   * optional parameters, call the {@link Listcloudtasks#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public Listcloudtasks listcloudtasks() throws java.io.IOException {
    Listcloudtasks result = new Listcloudtasks();
    initialize(result);
    return result;
  }

  public class Listcloudtasks extends CloudtaskendpointRequest<com.google.api.services.cloudtaskendpoint.model.CollectionResponseCloudTask> {

    private static final String REST_PATH = "listcloudtasks";

    /**
     * Create a request for the method "listcloudtasks".
     *
     * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting
     * any optional parameters, call the {@link Listcloudtasks#execute()} method to invoke the remote
     * operation. <p> {@link Listcloudtasks#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected Listcloudtasks() {
      super(Cloudtaskendpoint.this, "GET", REST_PATH, null, com.google.api.services.cloudtaskendpoint.model.CollectionResponseCloudTask.class);
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
    public Listcloudtasks setAlt(java.lang.String alt) {
      return (Listcloudtasks) super.setAlt(alt);
    }

    @Override
    public Listcloudtasks setFields(java.lang.String fields) {
      return (Listcloudtasks) super.setFields(fields);
    }

    @Override
    public Listcloudtasks setKey(java.lang.String key) {
      return (Listcloudtasks) super.setKey(key);
    }

    @Override
    public Listcloudtasks setOauthToken(java.lang.String oauthToken) {
      return (Listcloudtasks) super.setOauthToken(oauthToken);
    }

    @Override
    public Listcloudtasks setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Listcloudtasks) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Listcloudtasks setQuotaUser(java.lang.String quotaUser) {
      return (Listcloudtasks) super.setQuotaUser(quotaUser);
    }

    @Override
    public Listcloudtasks setUserIp(java.lang.String userIp) {
      return (Listcloudtasks) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public Listcloudtasks setCursor(java.lang.String cursor) {
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

    public Listcloudtasks setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public Listcloudtasks set(String parameterName, Object value) {
      return (Listcloudtasks) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeCloudTask".
   *
   * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting any
   * optional parameters, call the {@link RemoveCloudTask#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveCloudTask removeCloudTask(java.lang.Long id) throws java.io.IOException {
    RemoveCloudTask result = new RemoveCloudTask(id);
    initialize(result);
    return result;
  }

  public class RemoveCloudTask extends CloudtaskendpointRequest<com.google.api.services.cloudtaskendpoint.model.CloudTask> {

    private static final String REST_PATH = "cloudtask/{id}";

    /**
     * Create a request for the method "removeCloudTask".
     *
     * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting
     * any optional parameters, call the {@link RemoveCloudTask#execute()} method to invoke the remote
     * operation. <p> {@link RemoveCloudTask#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveCloudTask(java.lang.Long id) {
      super(Cloudtaskendpoint.this, "DELETE", REST_PATH, null, com.google.api.services.cloudtaskendpoint.model.CloudTask.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveCloudTask setAlt(java.lang.String alt) {
      return (RemoveCloudTask) super.setAlt(alt);
    }

    @Override
    public RemoveCloudTask setFields(java.lang.String fields) {
      return (RemoveCloudTask) super.setFields(fields);
    }

    @Override
    public RemoveCloudTask setKey(java.lang.String key) {
      return (RemoveCloudTask) super.setKey(key);
    }

    @Override
    public RemoveCloudTask setOauthToken(java.lang.String oauthToken) {
      return (RemoveCloudTask) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveCloudTask setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveCloudTask) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveCloudTask setQuotaUser(java.lang.String quotaUser) {
      return (RemoveCloudTask) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveCloudTask setUserIp(java.lang.String userIp) {
      return (RemoveCloudTask) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveCloudTask setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveCloudTask set(String parameterName, Object value) {
      return (RemoveCloudTask) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateCloudTask".
   *
   * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting any
   * optional parameters, call the {@link UpdateCloudTask#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.google.api.services.cloudtaskendpoint.model.CloudTask}
   * @return the request
   */
  public UpdateCloudTask updateCloudTask(com.google.api.services.cloudtaskendpoint.model.CloudTask content) throws java.io.IOException {
    UpdateCloudTask result = new UpdateCloudTask(content);
    initialize(result);
    return result;
  }

  public class UpdateCloudTask extends CloudtaskendpointRequest<com.google.api.services.cloudtaskendpoint.model.CloudTask> {

    private static final String REST_PATH = "updatecloudtask";

    /**
     * Create a request for the method "updateCloudTask".
     *
     * This request holds the parameters needed by the the cloudtaskendpoint server.  After setting
     * any optional parameters, call the {@link UpdateCloudTask#execute()} method to invoke the remote
     * operation. <p> {@link UpdateCloudTask#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.google.api.services.cloudtaskendpoint.model.CloudTask}
     * @since 1.13
     */
    protected UpdateCloudTask(com.google.api.services.cloudtaskendpoint.model.CloudTask content) {
      super(Cloudtaskendpoint.this, "POST", REST_PATH, content, com.google.api.services.cloudtaskendpoint.model.CloudTask.class);
    }

    @Override
    public UpdateCloudTask setAlt(java.lang.String alt) {
      return (UpdateCloudTask) super.setAlt(alt);
    }

    @Override
    public UpdateCloudTask setFields(java.lang.String fields) {
      return (UpdateCloudTask) super.setFields(fields);
    }

    @Override
    public UpdateCloudTask setKey(java.lang.String key) {
      return (UpdateCloudTask) super.setKey(key);
    }

    @Override
    public UpdateCloudTask setOauthToken(java.lang.String oauthToken) {
      return (UpdateCloudTask) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateCloudTask setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateCloudTask) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateCloudTask setQuotaUser(java.lang.String quotaUser) {
      return (UpdateCloudTask) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateCloudTask setUserIp(java.lang.String userIp) {
      return (UpdateCloudTask) super.setUserIp(userIp);
    }

    @Override
    public UpdateCloudTask set(String parameterName, Object value) {
      return (UpdateCloudTask) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Cloudtaskendpoint}.
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

    /** Builds a new instance of {@link Cloudtaskendpoint}. */
    @Override
    public Cloudtaskendpoint build() {
      return new Cloudtaskendpoint(this);
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
     * Set the {@link CloudtaskendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setCloudtaskendpointRequestInitializer(
        CloudtaskendpointRequestInitializer cloudtaskendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(cloudtaskendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
