/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.flexapi.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WebChannelUpdater extends Updater<WebChannel> {
    private final String pathSid;
    private WebChannel.ChatStatus chatStatus;
    private String postEngagementData;

    /**
     * Construct a new WebChannelUpdater.
     *
     * @param pathSid Channel Sid.
     */
    public WebChannelUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Chat status, can only used to make chat 'inactive'.
     *
     * @param chatStatus Chat status
     * @return this
     */
    public WebChannelUpdater setChatStatus(final WebChannel.ChatStatus chatStatus) {
        this.chatStatus = chatStatus;
        return this;
    }

    /**
     * Post-engagement data.
     *
     * @param postEngagementData Post-engagement data
     * @return this
     */
    public WebChannelUpdater setPostEngagementData(final String postEngagementData) {
        this.postEngagementData = postEngagementData;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated WebChannel
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public WebChannel update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.FLEXAPI.toString(),
            "/v1/WebChannels/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("WebChannel update failed: Unable to connect to server");
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

        return WebChannel.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (chatStatus != null) {
            request.addPostParam("ChatStatus", chatStatus.toString());
        }

        if (postEngagementData != null) {
            request.addPostParam("PostEngagementData", postEngagementData);
        }
    }
}