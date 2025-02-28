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

package com.twilio.rest.api.v2010.account.call;

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
public class UserDefinedMessage extends Resource {
    private static final long serialVersionUID = 278501461523415L;

    public static UserDefinedMessageCreator creator(final String pathCallSid, final String content){
        return new UserDefinedMessageCreator(pathCallSid, content);
    }
    public static UserDefinedMessageCreator creator(final String pathAccountSid, final String pathCallSid, final String content){
        return new UserDefinedMessageCreator(pathAccountSid, pathCallSid, content);
    }





    /**
    * Converts a JSON String into a UserDefinedMessage object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return UserDefinedMessage object represented by the provided JSON
    */
    public static UserDefinedMessage fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UserDefinedMessage.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a UserDefinedMessage object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return UserDefinedMessage object represented by the provided JSON
    */
    public static UserDefinedMessage fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UserDefinedMessage.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String callSid;
    private final String sid;
    private final ZonedDateTime dateCreated;

    @JsonCreator
    private UserDefinedMessage(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("call_sid")
        final String callSid,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("date_created")
        final String dateCreated
    ) {
        this.accountSid = accountSid;
        this.callSid = callSid;
        this.sid = sid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getCallSid() {
            return this.callSid;
        }
        public final String getSid() {
            return this.sid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDefinedMessage other = (UserDefinedMessage) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(callSid, other.callSid) &&  Objects.equals(sid, other.sid) &&  Objects.equals(dateCreated, other.dateCreated)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, callSid, sid, dateCreated);
    }

}

