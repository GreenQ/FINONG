package com.dailyappslab.finong;

import android.content.Context;
import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;

/**
 * Created by GreenQ on 16.09.2015.
 */
public class VkApp {
//    //constants for OAUTH AUTHORIZE in Vkontakte
//    public static final String CALLBACK_URL = "http://api.vkontakte.ru/blank.html";
//    private static final String OAUTH_AUTHORIZE_URL = "http://api.vkontakte.ru/oauth/authorize?client_id=2020214&scope=8192&redirect_uri=http://api.vkontakte.ru/blank.html&display=touch&response_type=token";
//
//    private Context _context;
//    private VkDialogListener _listener;
//    private VkSession _vkSess;
//
//    private String VK_API_URL = "https://api.vkontakte.ru/method/";
//    private String VK_POST_TO_WALL_URL = VK_API_URL + "wall.post?";
//    private boolean parseResponse(String jsonStr){
//        boolean errorFlag = true;
//
//        JSONObject jsonObj = null;
//        try {
//            jsonObj = new JSONObject(jsonStr);
//            JSONObject errorObj = null;
//
//            if( jsonObj.has("error") ) {
//                errorObj = jsonObj.getJSONObject("error");
//                int errCode = errorObj.getInt("error_code");
//                if( errCode == 14){
//                    errorFlag = false;
//                }
//            }
//        }
//        catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return errorFlag;
//    }
//
//    //publicate message to vk users' wall
//    public boolean postToWall(String message) {
//        boolean errorFlag = true;
//        String[] params = _vkSess.getAccessToken();
//
//        String accessToken = params[0];
//        String ownerId = params[2];
//
//        //set request uri params
//        VK_POST_TO_WALL_URL += "owner_id="+ownerId+"&message="+ Uri.encode(message)+"&access_token="+accessToken;
//
//        //send request to vkontakte api
//        HttpClient client = new DefaultHttpClient();
//        HttpGet request = new HttpGet(VK_POST_TO_WALL_URL);
//
//        try {
//            HttpResponse response = client.execute(request);
//            HttpEntity entity = response.getEntity();
//
//            String responseText = EntityUtils.toString(entity);
//
//            //parse response for error code or not
//            errorFlag = parseResponse(responseText);
//        }
//        catch(ClientProtocolException cexc){
//            cexc.printStackTrace();
//        }
//        catch(IOException ioex){
//            ioex.printStackTrace();
//        }
//
//        return errorFlag;
//    }
}
