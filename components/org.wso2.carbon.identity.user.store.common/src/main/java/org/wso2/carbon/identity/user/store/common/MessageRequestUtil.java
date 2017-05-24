/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.identity.user.store.common;

import org.json.JSONObject;
import org.wso2.carbon.identity.user.store.common.model.UserOperation;

/**
 * Message request utility to create user operation message which send to queue
 */
public class MessageRequestUtil {

    public static String getAuthenticationRequest(String userName, Object credential) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", userName);
        jsonObject.put("password", credential);
        return jsonObject.toString();
    }

    public static String getRoleListRequest(String filter, int limit) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("filter", filter);
        jsonObject.put("limit", limit);
        return jsonObject.toString();
    }

    public static String getUserListRequest(String filter, int limit) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("filter", filter);
        jsonObject.put("limit", limit);
        return jsonObject.toString();
    }

    public static String getUserPropertyValuesRequestData(String username, String attributes) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("attributes", attributes);
        return jsonObject.toString();
    }

    public static String doGetExternalRoleListOfUserRequestData(String username) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        return jsonObject.toString();
    }

    public static String getUserOperationJSONMessage(UserOperation userOperation) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(UserStoreConstants.UM_JSON_ELEMENT_REQUEST_DATA_CORRELATION_ID, userOperation.getCorrelationId());
        jsonObject.put(UserStoreConstants.UM_JSON_ELEMENT_REQUEST_DATA_TYPE, userOperation.getRequestType());
        jsonObject.put(UserStoreConstants.UM_JSON_ELEMENT_REQUEST_DATA, new JSONObject(userOperation.getRequestData()));
        return jsonObject.toString();
    }

    public static String getUserResponseJSONMessage(String correlationId, String result) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(UserStoreConstants.UM_JSON_ELEMENT_REQUEST_DATA_CORRELATION_ID, correlationId);
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put(UserStoreConstants.UM_JSON_ELEMENT_RESPONSE_DATA_RESULT, result);
        jsonObject.put(UserStoreConstants.UM_JSON_ELEMENT_RESPONSE_DATA, jsonResponse);
        return jsonObject.toString();
    }
}
