/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.flexapi.v1;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ChannelCreator extends Creator<Channel> {
    private final String flexFlowSid;
    private final String identity;
    private final String chatUserFriendlyName;
    private final String chatFriendlyName;
    private String target;
    private String chatUniqueName;
    private String preEngagementData;
    private String taskSid;
    private String taskAttributes;
    private Boolean longLived;

    /**
     * Construct a new ChannelCreator.
     *
     * @param flexFlowSid The unique ID of the FlexFlow
     * @param identity Chat User identity
     * @param chatUserFriendlyName Customer friendly name
     * @param chatFriendlyName Chat channel friendly name
     */
    public ChannelCreator(final String flexFlowSid,
                          final String identity,
                          final String chatUserFriendlyName,
                          final String chatFriendlyName) {
        this.flexFlowSid = flexFlowSid;
        this.identity = identity;
        this.chatUserFriendlyName = chatUserFriendlyName;
        this.chatFriendlyName = chatFriendlyName;
    }

    /**
     * Target Contact Identity, for example phone number for SMS.
     *
     * @param target Target Contact Identity
     * @return this
     */
    public ChannelCreator setTarget(final String target) {
        this.target = target;
        return this;
    }

    /**
     * Chat channel unique name.
     *
     * @param chatUniqueName Chat channel unique name
     * @return this
     */
    public ChannelCreator setChatUniqueName(final String chatUniqueName) {
        this.chatUniqueName = chatUniqueName;
        return this;
    }

    /**
     * Pre-engagement data.
     *
     * @param preEngagementData Pre-engagement data
     * @return this
     */
    public ChannelCreator setPreEngagementData(final String preEngagementData) {
        this.preEngagementData = preEngagementData;
        return this;
    }

    /**
     * The unique SID identifier of the Taskrouter task.
     *
     * @param taskSid TaskRouter Task Sid.
     * @return this
     */
    public ChannelCreator setTaskSid(final String taskSid) {
        this.taskSid = taskSid;
        return this;
    }

    /**
     * Task attributes to be added for the TaskRouter Task.
     *
     * @param taskAttributes Task attributes to be added for the TaskRouter Task
     * @return this
     */
    public ChannelCreator setTaskAttributes(final String taskAttributes) {
        this.taskAttributes = taskAttributes;
        return this;
    }

    /**
     * Boolean flag determining whether channel is created as long lived or not.
     *
     * @param longLived Long Lived flag
     * @return this
     */
    public ChannelCreator setLongLived(final Boolean longLived) {
        this.longLived = longLived;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Channel
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Channel create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.FLEXAPI.toString(),
            "/v1/Channels",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Channel creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Channel.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (flexFlowSid != null) {
            request.addPostParam("FlexFlowSid", flexFlowSid);
        }

        if (identity != null) {
            request.addPostParam("Identity", identity);
        }

        if (chatUserFriendlyName != null) {
            request.addPostParam("ChatUserFriendlyName", chatUserFriendlyName);
        }

        if (chatFriendlyName != null) {
            request.addPostParam("ChatFriendlyName", chatFriendlyName);
        }

        if (target != null) {
            request.addPostParam("Target", target);
        }

        if (chatUniqueName != null) {
            request.addPostParam("ChatUniqueName", chatUniqueName);
        }

        if (preEngagementData != null) {
            request.addPostParam("PreEngagementData", preEngagementData);
        }

        if (taskSid != null) {
            request.addPostParam("TaskSid", taskSid);
        }

        if (taskAttributes != null) {
            request.addPostParam("TaskAttributes", taskAttributes);
        }

        if (longLived != null) {
            request.addPostParam("LongLived", longLived.toString());
        }
    }
}