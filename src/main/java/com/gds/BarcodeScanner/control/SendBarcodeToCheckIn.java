package com.gds.BarcodeScanner.control;

import com.gds.Common.control.GetErrorLogger;
import com.gds.Common.control.GetInfoLogger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by rickzx98 on 28/07/2016.
 */
public class SendBarcodeToCheckIn {
    private final GetInfoLogger infoLogger = new GetInfoLogger();
    private final GetErrorLogger errorLogger = new GetErrorLogger();
    private final String SCANNER_URL = System.getenv("GDS_SCANNER_URL");

    public void execute(final String barcode, final Long when) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(SCANNER_URL);
                post.setHeader("Content-type", "application/json");
                JSONObject reqJSON = new JSONObject();
                reqJSON.put("barcode", barcode);
                reqJSON.put("when", String.valueOf(when));
                StringEntity requestEntity = new StringEntity(reqJSON.toString(), ContentType.APPLICATION_JSON);
                post.setEntity(requestEntity);
                try {
                    HttpResponse rawResponse = client.execute(post);
                    if (rawResponse.getStatusLine().getStatusCode() == 200) {
                        infoLogger.execute(SendBarcodeToCheckIn.class, "Barcode has been logged", null);
                    }
                } catch (IOException e) {
                    errorLogger.execute(SendBarcodeToCheckIn.class, e.getMessage(), e);
                }
            }
        }).start();

    }

}
