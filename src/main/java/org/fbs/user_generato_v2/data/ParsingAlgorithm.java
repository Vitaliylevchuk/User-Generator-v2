package org.fbs.user_generato_v2.data;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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
