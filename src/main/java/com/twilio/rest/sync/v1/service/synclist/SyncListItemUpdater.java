/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.synclist;

import com.twilio.base.Updater;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

public class SyncListItemUpdater extends Updater<SyncListItem> {
    private final String pathServiceSid;
    private final String pathListSid;
    private final Integer pathIndex;
    private Map<String, Object> data;
    private Integer ttl;
    private Integer itemTtl;
    private Integer collectionTtl;
    private String ifMatch;

    /**
     * Construct a new SyncListItemUpdater.
     *
     * @param pathServiceSid The SID of the Sync Service with the Sync List Item
     *                       resource to update
     * @param pathListSid The SID of the Sync List with the Sync List Item resource
     *                    to update
     * @param pathIndex The index of the Sync List Item resource to update
     */
    public SyncListItemUpdater(final String pathServiceSid,
                               final String pathListSid,
                               final Integer pathIndex) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
        this.pathIndex = pathIndex;
    }

    /**
     * A JSON string that represents an arbitrary, schema-less object that the List
     * Item stores. Can be up to 16 KiB in length..
     *
     * @param data A JSON string that represents an arbitrary, schema-less object
     *             that the List Item stores
     * @return this
     */
    public SyncListItemUpdater setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    /**
     * An alias for `item_ttl`. If both parameters are provided, this value is
     * ignored..
     *
     * @param ttl An alias for item_ttl
     * @return this
     */
    public SyncListItemUpdater setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * How long, in seconds, before the List Item expires (time-to-live) and is
     * deleted.  Can be an integer from 0 to 31,536,000 (1 year). The default value
     * is `0`, which means the List Item does not expire. The List Item will be
     * deleted automatically after it expires, but there can be a delay between the
     * expiration time and the resources's deletion..
     *
     * @param itemTtl How long, in seconds, before the List Item expires
     * @return this
     */
    public SyncListItemUpdater setItemTtl(final Integer itemTtl) {
        this.itemTtl = itemTtl;
        return this;
    }

    /**
     * How long, in seconds, before the List Item's parent Sync List expires
     * (time-to-live) and is deleted.  Can be an integer from 0 to 31,536,000 (1
     * year). The default value is `0`, which means the parent Sync List does not
     * expire. The Sync List will be deleted automatically after it expires, but
     * there can be a delay between the expiration time and the resources's
     * deletion..
     *
     * @param collectionTtl How long, in seconds, before the List Item's parent
     *                      Sync List expires
     * @return this
     */
    public SyncListItemUpdater setCollectionTtl(final Integer collectionTtl) {
        this.collectionTtl = collectionTtl;
        return this;
    }

    /**
     * If provided, applies this mutation if (and only if) the “revision” field of
     * this <a
     * href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Match">map
     * item] matches the provided value. This matches the semantics of (and is
     * implemented with) the HTTP [If-Match header</a>..
     *
     * @param ifMatch The If-Match HTTP request header
     * @return this
     */
    public SyncListItemUpdater setIfMatch(final String ifMatch) {
        this.ifMatch = ifMatch;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated SyncListItem
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncListItem update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Lists/" + this.pathListSid + "/Items/" + this.pathIndex + ""
        );

        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncListItem update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SyncListItem.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested header parameters to the Request.
     *
     * @param request Request to add header params to
     */
    private void addHeaderParams(final Request request) {
        if (ifMatch != null) {
            request.addHeaderParam("If-Match", ifMatch);
        }
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }

        if (itemTtl != null) {
            request.addPostParam("ItemTtl", itemTtl.toString());
        }

        if (collectionTtl != null) {
            request.addPostParam("CollectionTtl", collectionTtl.toString());
        }
    }
}