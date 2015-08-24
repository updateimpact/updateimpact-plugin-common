package com.updateimpact.report;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GzipCompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ReportSubmitter {
    private static final HttpClient HTTP_CLIENT = HttpClientBuilder.create().build();

    private final String url;
    private final SubmitLogger log;

    public ReportSubmitter(String url, SubmitLogger log) {
        this.url = url;
        this.log = log;
    }

    public String trySubmitReport(DependencyReport dr) {
        String report = new Gson().toJson(dr);
        try {
            return submitReport(report);
        } catch (IOException e) {
            throw new RuntimeException("Exception when submitting the dependency report", e);
        }
    }

    public String submitReport(String report) throws IOException {
        String submitUrl = url + "/api/submit";

        log.info("");
        log.info("Submitting dependency report to " + submitUrl);
        HttpPost post = new HttpPost(submitUrl);
        post.setEntity(new GzipCompressingEntity(new StringEntity(report)));
        HttpResponse response = HTTP_CLIENT.execute(post);

        String responseJson = EntityUtils.toString(response.getEntity());
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode < 200 || statusCode > 300) {
            log.error("Cannot submit report to " + submitUrl + ", got response " + statusCode +
                    ": " + responseJson);

            return null;
        } else {
            SubmitResponse submitResponse = new Gson().fromJson(responseJson, SubmitResponse.class);
            String viewLink = url + "/builds/" + submitResponse.getUserIdStr() + "/" + submitResponse.getBuildId();

            log.info("");
            log.info("Dependency report submitted. You can view it at: ");
            log.info(viewLink);
            log.info("");

            return viewLink;
        }
    }
}
