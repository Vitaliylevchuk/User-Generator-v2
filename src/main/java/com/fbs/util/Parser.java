package com.fbs.util;

import com.fbs.data.ConnectParameter;
import com.fbs.data.ConnectParameters;
import com.fbs.data.Website;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.helper.ValidationException;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class Parser {

    private Website parserWebsite;

    public ConnectParameters getConnectParameters() {
        return connectParameters;
    }

    public ConnectParameters connectParameters = new ConnectParameters();

    public Parser(Website website){
        parserWebsite = website;
        initConnectParameters();
    }

    public void initConnectParameters(){
        connectParameters.getParameters().add(new ConnectParameter("userAgent", "Mozilla"));
        connectParameters.getParameters().add(new ConnectParameter("cookie", "cookieValue0", "cookieValue1"));
        connectParameters.getParameters().add(new ConnectParameter("referrer", "https://google.com"));
        connectParameters.getParameters().add(new ConnectParameter("header", "headerValue0", "headerValue1"));
        connectParameters.getParameters().add(new ConnectParameter("data", "", ""));
        connectParameters.getParameters().add(new ConnectParameter("proxy", ""));
    }

    public @Nullable Document getDocument() throws IOException {
        try {
            return Jsoup.connect(parserWebsite.getSite())
                    .userAgent(connectParameters.getByName("userAgent").getParameterValue(0).toString())
                    .cookie(connectParameters.getByName("cookie").getParameterValue(0).toString(), connectParameters.getByName("cookie").getParameterValue(1).toString())
                    .referrer(connectParameters.getByName("referrer").getParameterValue(0).toString())
                    .header(connectParameters.getByName("header").getParameterValue(0).toString(), connectParameters.getByName("header").getParameterValue(1).toString())
                    .data(connectParameters.getByName("data").getParameterValue(0).toString(), connectParameters.getByName("data").getParameterValue(1).toString())
                    .get();
        }
        catch (ValidationException e){
            return Jsoup.connect(parserWebsite.getSite())
                    .userAgent(connectParameters.getByName("userAgent").getParameterValue(0).toString())
                    .cookie(connectParameters.getByName("cookie").getParameterValue(0).toString(), connectParameters.getByName("cookie").getParameterValue(1).toString())
                    .referrer(connectParameters.getByName("referrer").getParameterValue(0).toString())
                    .header(connectParameters.getByName("header").getParameterValue(0).toString(), connectParameters.getByName("header").getParameterValue(1).toString())
                    .get();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public @Nullable Document getDocumentUsingProxy() throws IOException {
        try {
            return Jsoup.connect(parserWebsite.getSite())
                    .userAgent(connectParameters.getByName("userAgent").getParameterValue(0).toString())
                    .cookie(connectParameters.getByName("cookie").getParameterValue(0).toString(), connectParameters.getByName("cookie").getParameterValue(1).toString())
                    .referrer(connectParameters.getByName("referrer").getParameterValue(0).toString())
                    .header(connectParameters.getByName("header").getParameterValue(0).toString(), connectParameters.getByName("header").getParameterValue(1).toString())
                    .data(connectParameters.getByName("data").getParameterValue(0).toString(), connectParameters.getByName("data").getParameterValue(1).toString())
                    .proxy(connectParameters.getByName("proxy").getParameterValue(0).toString(),(int) connectParameters.getByName("proxy").getParameterValue(1))
                    .get();
        }
        catch (ValidationException e){
            return Jsoup.connect(parserWebsite.getSite())
                    .userAgent(connectParameters.getByName("userAgent").getParameterValue(0).toString())
                    .cookie(connectParameters.getByName("cookie").getParameterValue(0).toString(), connectParameters.getByName("cookie").getParameterValue(1).toString())
                    .referrer(connectParameters.getByName("referrer").getParameterValue(0).toString())
                    .header(connectParameters.getByName("header").getParameterValue(0).toString(), connectParameters.getByName("header").getParameterValue(1).toString())
                    .proxy(connectParameters.getByName("proxy").getParameterValue(0).toString(),(int) connectParameters.getByName("proxy").getParameterValue(1))
                    .get();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
