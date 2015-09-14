package com.github.rayboot.tf_plus.utils;

import android.net.Uri;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

/**
 * @author rayboot
 * @from 14-5-30 17:15
 * @TODO
 */
public class NginxRequestTransformer implements Picasso.RequestTransformer {
    @Override
    public Request transformRequest(Request request) {
        if (request.resourceId != 0) {
            return request; // Don't transform resource requests.
        }
        Uri uri = request.uri;
        String scheme = uri.getScheme();
        if (!"https".equals(scheme) && !"http".equals(scheme)) {
            return request;
        }
        if (!request.hasSize()) {
            return request;
        }

        // Start building a new request for us to mutate.
        Request.Builder newRequest = request.buildUpon();

        //String imgUrl = uri.getScheme() + ":" + uri.getSchemeSpecificPart();
        String imgUrl = uri.toString();
        if (uri.getPath().indexOf('.') == -1) {
            return request;
        }
        String nginxEx = "!"
                + (request.centerInside ? "t" : "m")
                + request.targetWidth
                + "x"
                + request.targetHeight
                + uri.getPath().substring(uri.getPath().indexOf("."));
        String newImageUrl = imgUrl + nginxEx;

        Log.e("aaa", "transformRequest " + newImageUrl);
        newRequest.setUri(Uri.parse(newImageUrl));

        return newRequest.build();
    }
}
