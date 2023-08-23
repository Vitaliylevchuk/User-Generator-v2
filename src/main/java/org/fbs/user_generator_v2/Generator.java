package org.fbs.user_generator_v2;

import org.fbs.user_generator_v2.data.ParsingAlgorithm;
import org.fbs.user_generator_v2.data.People;
import org.fbs.user_generator_v2.util.Parser;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Generator {

    public ParsingAlgorithm getParsingAlgorithm() {
        return parsingAlgorithm;
    }

    private ParsingAlgorithm parsingAlgorithm;
    private Parser parser;
    private boolean parseWithEditedProxy;

    private Document document;

    public Document getDocument() {
        return document;
    }

    public Elements getElements() {
        return elements;
    }

    private Elements elements;

    public Generator(@NotNull ParsingAlgorithm parsingAlgorithm, @NotNull Parser parser, boolean parseWithEditedProxy) throws IOException {
        this.parsingAlgorithm = parsingAlgorithm;
        this.parser = parser;
        this.parseWithEditedProxy = parseWithEditedProxy;

        document = generateDocument();
        elements = generateElement(document);

    }

    public People generatePeople(int heightMin, int heightMax, int weightMin, int weightMax, int ageMin, int ageMax) throws IOException {
        int height;
        int weight;
        int age;
        int index;

        try {
            index = (Integer) parsingAlgorithm.getArgs()[0];
        }catch (NullPointerException e){
            index = 0;
        }

        try {
            age = (Integer) parsingAlgorithm.getArgs()[1];
        }catch (NullPointerException e){
            age = ageMin + new Random().nextInt(ageMax - ageMin);
        }

        try{
            weight = (Integer) parsingAlgorithm.getArgs()[2];
        }catch (NullPointerException e){
            weight = weightMin + new Random().nextInt(weightMax - weightMin);
        }

        try{
            height = (Integer) parsingAlgorithm.getArgs()[3];
        }catch (NullPointerException e){
            height = heightMin + new Random().nextInt(heightMax - heightMin);
        }

        String id = String.valueOf(("" + height + weight + age).hashCode()) + elements.get(index).text().replaceAll(" ", "").toLowerCase();

        return new People(Objects.requireNonNull(elements.get(index)).text(), age, height, weight, id);

    }

    public Document generateDocument() throws IOException {
        return parseWithEditedProxy ? parser.getDocumentUsingProxy() : parser.getDocument();
    }

    public Elements generateElement(Document document){
        return parsingAlgorithm.parsing(document);
    }

}
