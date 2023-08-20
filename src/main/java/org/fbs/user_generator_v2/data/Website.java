package org.fbs.user_generator_v2.data;

public class Website {

    private final String site;
    public Website(String url){
        site = url;
    }
    public String getSite(){
        return site;
    }


    public static Website name_generator_org = new Website("https://www.name-generator.org.uk/quick/");

}
