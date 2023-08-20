package com.fbs.data;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParsingAlgorithm {

    private Object[] args = new Object[4];

    public Elements parsing(Document document){
        return null;
    }

    public void setArg(int index, Object arg){
        try {
            args[index] = arg;
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public Object[] getArgs() {
        return args;
    }

    public static ParsingAlgorithm name_generator_orgAlgorithm = new ParsingAlgorithm(){

        @Override
        public Elements parsing(@NotNull Document document) {
            return document.select("div.name_heading");
        }
    };

}
