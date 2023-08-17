package com.fbs.data;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParsingAlgorithm {

    private Object[] args;

    public Elements parsing(Document document){
        return null;
    }

    public void setArgs(Object ... args){
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

    public static ParsingAlgorithm name_generator_orgAlgorithm = new ParsingAlgorithm(){

        @Override
        public Elements parsing(@NotNull Document document) {
            System.out.println(getArgs()[0].getClass());
            return document.select("div.name_heading");
        }
    };

}
