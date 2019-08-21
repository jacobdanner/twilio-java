/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.flexapi.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel extends Resource {
    private static final long serialVersionUID = 192292992411746L;

    /**
     * Create a ChannelReader to execute read.
     *
     * @return ChannelReader capable of executing the read
     */
    public static ChannelReader reader() {
        return new ChannelReader();
    }

    /**
     * Create a ChannelFetcher to execute fetch.
     *
     * @param pathSid Flex Chat Channel Sid
     * @return ChannelFetcher capable of executing the fetch
     */
    public static ChannelFetcher fetcher(final String pathSid) {
        return new ChannelFetcher(pathSid);
    }

    /**
     * Create a ChannelCreator to execute create.
     *
     * @param flexFlowSid The unique ID of the FlexFlow
     * @param identity Chat User identity
     * @param chatUserFriendlyName Customer friendly name
     * @param chatFriendlyName Chat channel friendly name
     * @return ChannelCreator capable of executing the create
     */
    public static ChannelCreator creator(final String flexFlowSid,
                                         final String identity,
                                         final String chatUserFriendlyName,
                                         final String chatFriendlyName) {
        return new ChannelCreator(flexFlowSid, identity, chatUserFriendlyName, chatFriendlyName);
    }

    /**
     * Create a ChannelDeleter to execute delete.
     *
     * @param pathSid Flex Chat Channel Sid
     * @return ChannelDeleter capable of executing the delete
     */
    public static ChannelDeleter deleter(final String pathSid) {
        return new ChannelDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a Channel object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Channel object represented by the provided JSON
     */
    public static Channel fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Channel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Channel object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Channel object represented by the provided JSON
     */
    public static Channel fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Channel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String flexFlowSid;
    private final String sid;
    private final String userSid;
    private final String taskSid;
    private final URI url;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;

    @JsonCreator
    private Channel(@JsonProperty("account_sid")
                    final String accountSid,
                    @JsonProperty("flex_flow_sid")
                    final String flexFlowSid,
                    @JsonProperty("sid")
                    final String sid,
                    @JsonProperty("user_sid")
                    final String userSid,
                    @JsonProperty("task_sid")
                    final String taskSid,
                    @JsonProperty("url")
                    final URI url,
                    @JsonProperty("date_created")
                    final String dateCreated,
                    @JsonProperty("date_updated")
                    final String dateUpdated) {
        this.accountSid = accountSid;
        this.flexFlowSid = flexFlowSid;
        this.sid = sid;
        this.userSid = userSid;
        this.taskSid = taskSid;
        this.url = url;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    /**
     * Returns The The ID of the account that owns this Workflow.
     *
     * @return The ID of the account that owns this Workflow
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The unique ID of the FlexFlow.
     *
     * @return The unique ID of the FlexFlow
     */
    public final String getFlexFlowSid() {
        return this.flexFlowSid;
    }

    /**
     * Returns The Flex Chat Channel Sid.
     *
     * @return Flex Chat Channel Sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Chat User Sid..
     *
     * @return Chat User Sid.
     */
    public final String getUserSid() {
        return this.userSid;
    }

    /**
     * Returns The TaskRouter Task Sid..
     *
     * @return TaskRouter Task Sid.
     */
    public final String getTaskSid() {
        return this.taskSid;
    }

    /**
     * Returns The The url.
     *
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The time the Flex Chat Channel was created, given as GMT in ISO
     * 8601 format..
     *
     * @return The time the Flex Chat Channel was created, given as GMT in ISO 8601
     *         format.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The time the Flex Chat Channel was last updated, given as GMT in
     * ISO 8601 format..
     *
     * @return The time the Flex Chat Channel was last updated, given as GMT in ISO
     *         8601 format.
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Channel other = (Channel) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(flexFlowSid, other.flexFlowSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(userSid, other.userSid) &&
               Objects.equals(taskSid, other.taskSid) &&
               Objects.equals(url, other.url) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            flexFlowSid,
                            sid,
                            userSid,
                            taskSid,
                            url,
                            dateCreated,
                            dateUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("flexFlowSid", flexFlowSid)
                          .add("sid", sid)
                          .add("userSid", userSid)
                          .add("taskSid", taskSid)
                          .add("url", url)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .toString();
    }
}