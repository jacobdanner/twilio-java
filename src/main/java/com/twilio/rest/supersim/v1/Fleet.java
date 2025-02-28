/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Supersim
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.supersim.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;
import com.twilio.http.HttpMethod;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Objects;



@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Fleet extends Resource {
    private static final long serialVersionUID = 74063802547191L;

    public static FleetCreator creator(final String networkAccessProfile){
        return new FleetCreator(networkAccessProfile);
    }

    public static FleetFetcher fetcher(final String pathSid){
        return new FleetFetcher(pathSid);
    }


    public static FleetReader reader(){
        return new FleetReader();
    }

    public static FleetUpdater updater(final String pathSid){
        return new FleetUpdater(pathSid);
    }

    /**
    * Converts a JSON String into a Fleet object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Fleet object represented by the provided JSON
    */
    public static Fleet fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Fleet.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Fleet object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Fleet object represented by the provided JSON
    */
    public static Fleet fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Fleet.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum DataMetering {
        PAYG("payg");

        private final String value;

        private DataMetering(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static DataMetering forValue(final String value) {
            return Promoter.enumFromString(value, DataMetering.values());
        }
    }

    private final String accountSid;
    private final String sid;
    private final String uniqueName;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Boolean dataEnabled;
    private final Integer dataLimit;
    private final Fleet.DataMetering dataMetering;
    private final Boolean smsCommandsEnabled;
    private final URI smsCommandsUrl;
    private final HttpMethod smsCommandsMethod;
    private final String networkAccessProfileSid;
    private final URI ipCommandsUrl;
    private final HttpMethod ipCommandsMethod;

    @JsonCreator
    private Fleet(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("unique_name")
        final String uniqueName,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("data_enabled")
        final Boolean dataEnabled,

        @JsonProperty("data_limit")
        final Integer dataLimit,

        @JsonProperty("data_metering")
        final Fleet.DataMetering dataMetering,

        @JsonProperty("sms_commands_enabled")
        final Boolean smsCommandsEnabled,

        @JsonProperty("sms_commands_url")
        final URI smsCommandsUrl,

        @JsonProperty("sms_commands_method")
        final HttpMethod smsCommandsMethod,

        @JsonProperty("network_access_profile_sid")
        final String networkAccessProfileSid,

        @JsonProperty("ip_commands_url")
        final URI ipCommandsUrl,

        @JsonProperty("ip_commands_method")
        final HttpMethod ipCommandsMethod
    ) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.uniqueName = uniqueName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.dataEnabled = dataEnabled;
        this.dataLimit = dataLimit;
        this.dataMetering = dataMetering;
        this.smsCommandsEnabled = smsCommandsEnabled;
        this.smsCommandsUrl = smsCommandsUrl;
        this.smsCommandsMethod = smsCommandsMethod;
        this.networkAccessProfileSid = networkAccessProfileSid;
        this.ipCommandsUrl = ipCommandsUrl;
        this.ipCommandsMethod = ipCommandsMethod;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getSid() {
            return this.sid;
        }
        public final String getUniqueName() {
            return this.uniqueName;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Boolean getDataEnabled() {
            return this.dataEnabled;
        }
        public final Integer getDataLimit() {
            return this.dataLimit;
        }
        public final Fleet.DataMetering getDataMetering() {
            return this.dataMetering;
        }
        public final Boolean getSmsCommandsEnabled() {
            return this.smsCommandsEnabled;
        }
        public final URI getSmsCommandsUrl() {
            return this.smsCommandsUrl;
        }
        public final HttpMethod getSmsCommandsMethod() {
            return this.smsCommandsMethod;
        }
        public final String getNetworkAccessProfileSid() {
            return this.networkAccessProfileSid;
        }
        public final URI getIpCommandsUrl() {
            return this.ipCommandsUrl;
        }
        public final HttpMethod getIpCommandsMethod() {
            return this.ipCommandsMethod;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fleet other = (Fleet) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(sid, other.sid) &&  Objects.equals(uniqueName, other.uniqueName) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url) &&  Objects.equals(dataEnabled, other.dataEnabled) &&  Objects.equals(dataLimit, other.dataLimit) &&  Objects.equals(dataMetering, other.dataMetering) &&  Objects.equals(smsCommandsEnabled, other.smsCommandsEnabled) &&  Objects.equals(smsCommandsUrl, other.smsCommandsUrl) &&  Objects.equals(smsCommandsMethod, other.smsCommandsMethod) &&  Objects.equals(networkAccessProfileSid, other.networkAccessProfileSid) &&  Objects.equals(ipCommandsUrl, other.ipCommandsUrl) &&  Objects.equals(ipCommandsMethod, other.ipCommandsMethod)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, sid, uniqueName, dateCreated, dateUpdated, url, dataEnabled, dataLimit, dataMetering, smsCommandsEnabled, smsCommandsUrl, smsCommandsMethod, networkAccessProfileSid, ipCommandsUrl, ipCommandsMethod);
    }

}

