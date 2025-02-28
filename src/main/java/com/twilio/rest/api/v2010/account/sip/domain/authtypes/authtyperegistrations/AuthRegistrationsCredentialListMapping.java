/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.sip.domain.authtypes.authtyperegistrations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;

import java.util.Objects;



@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AuthRegistrationsCredentialListMapping extends Resource {
    private static final long serialVersionUID = 16012497789519L;

    public static AuthRegistrationsCredentialListMappingCreator creator(final String pathDomainSid, final String credentialListSid){
        return new AuthRegistrationsCredentialListMappingCreator(pathDomainSid, credentialListSid);
    }
    public static AuthRegistrationsCredentialListMappingCreator creator(final String pathAccountSid, final String pathDomainSid, final String credentialListSid){
        return new AuthRegistrationsCredentialListMappingCreator(pathAccountSid, pathDomainSid, credentialListSid);
    }

    public static AuthRegistrationsCredentialListMappingFetcher fetcher(final String pathDomainSid, final String pathSid){
        return new AuthRegistrationsCredentialListMappingFetcher(pathDomainSid, pathSid);
    }
    public static AuthRegistrationsCredentialListMappingFetcher fetcher(final String pathAccountSid, final String pathDomainSid, final String pathSid){
        return new AuthRegistrationsCredentialListMappingFetcher(pathAccountSid, pathDomainSid, pathSid);
    }

    public static AuthRegistrationsCredentialListMappingDeleter deleter(final String pathDomainSid, final String pathSid){
        return new AuthRegistrationsCredentialListMappingDeleter(pathDomainSid, pathSid);
    }
    public static AuthRegistrationsCredentialListMappingDeleter deleter(final String pathAccountSid, final String pathDomainSid, final String pathSid){
        return new AuthRegistrationsCredentialListMappingDeleter(pathAccountSid, pathDomainSid, pathSid);
    }

    public static AuthRegistrationsCredentialListMappingReader reader(final String pathDomainSid){
        return new AuthRegistrationsCredentialListMappingReader(pathDomainSid);
    }
    public static AuthRegistrationsCredentialListMappingReader reader(final String pathAccountSid, final String pathDomainSid){
        return new AuthRegistrationsCredentialListMappingReader(pathAccountSid, pathDomainSid);
    }


    /**
    * Converts a JSON String into a AuthRegistrationsCredentialListMapping object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return AuthRegistrationsCredentialListMapping object represented by the provided JSON
    */
    public static AuthRegistrationsCredentialListMapping fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AuthRegistrationsCredentialListMapping.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a AuthRegistrationsCredentialListMapping object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return AuthRegistrationsCredentialListMapping object represented by the provided JSON
    */
    public static AuthRegistrationsCredentialListMapping fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AuthRegistrationsCredentialListMapping.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final String sid;

    @JsonCreator
    private AuthRegistrationsCredentialListMapping(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("sid")
        final String sid
    ) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.sid = sid;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final String getSid() {
            return this.sid;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthRegistrationsCredentialListMapping other = (AuthRegistrationsCredentialListMapping) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(sid, other.sid)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, dateCreated, dateUpdated, friendlyName, sid);
    }

}

