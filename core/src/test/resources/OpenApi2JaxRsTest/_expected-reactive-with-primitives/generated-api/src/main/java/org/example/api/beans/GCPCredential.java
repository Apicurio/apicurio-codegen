
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GCPCredential
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "project_id",
    "private_key_id",
    "private_key",
    "client_email",
    "client_id",
    "auth_uri",
    "token_uri",
    "auth_provider_x509_cert_url",
    "client_x509_cert_url"
})
@Generated("jsonschema2pojo")
public class GCPCredential {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    private String type;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("project_id")
    private String projectId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("private_key_id")
    private String privateKeyId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("private_key")
    private String privateKey;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_email")
    private String clientEmail;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_id")
    private String clientId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("auth_uri")
    private String authUri;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("token_uri")
    private String tokenUri;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("auth_provider_x509_cert_url")
    private String authProviderX509CertUrl;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_x509_cert_url")
    private String clientX509CertUrl;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("project_id")
    public String getProjectId() {
        return projectId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("project_id")
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("private_key_id")
    public String getPrivateKeyId() {
        return privateKeyId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("private_key_id")
    public void setPrivateKeyId(String privateKeyId) {
        this.privateKeyId = privateKeyId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("private_key")
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("private_key")
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_email")
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_email")
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_id")
    public String getClientId() {
        return clientId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_id")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("auth_uri")
    public String getAuthUri() {
        return authUri;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("auth_uri")
    public void setAuthUri(String authUri) {
        this.authUri = authUri;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("token_uri")
    public String getTokenUri() {
        return tokenUri;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("token_uri")
    public void setTokenUri(String tokenUri) {
        this.tokenUri = tokenUri;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("auth_provider_x509_cert_url")
    public String getAuthProviderX509CertUrl() {
        return authProviderX509CertUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("auth_provider_x509_cert_url")
    public void setAuthProviderX509CertUrl(String authProviderX509CertUrl) {
        this.authProviderX509CertUrl = authProviderX509CertUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_x509_cert_url")
    public String getClientX509CertUrl() {
        return clientX509CertUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_x509_cert_url")
    public void setClientX509CertUrl(String clientX509CertUrl) {
        this.clientX509CertUrl = clientX509CertUrl;
    }

}
