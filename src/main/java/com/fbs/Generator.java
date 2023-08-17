package com.fbs;

import com.fbs.data.ParsingAlgorithm;
import com.fbs.data.People;
import com.fbs.data.Website;
import com.fbs.util.Parser;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Generator {

    private Website website;
    private ParsingAlgorithm parsingAlgorithm;
    private Parser parser;
    private boolean parseWithEditedProxy;

    public Generator(@NotNull Website website, @NotNull ParsingAlgorithm parsingAlgorithm, @NotNull Parser parser, boolean parseWithEditedProxy){
        this.website = website;
        this.parsingAlgorithm = parsingAlgorithm;
        this.parser = parser;
        this.parseWithEditedProxy = parseWithEditedProxy;
    }

    public People generatePeople(int heightMin, int heightMax, int weightMin, int weightMax, int ageMin, int ageMax) throws IOException {
        int height = heightMin + new Random().nextInt(heightMax - heightMin);
        int weight = weightMin + new Random().nextInt(weightMax - weightMin);
        int age = ageMin + new Random().nextInt(ageMax - ageMin);

        Document doc = generateDocument();
        Elements els = generateElement(doc);

        return new People(Objects.requireNonNull(els.get((Integer) parsingAlgorithm.getArgs()[0])).text(), age, height, weight);
    }

    public Document generateDocument() throws IOException {
        return parseWithEditedProxy ? parser.getDocumentUsingProxy() : parser.getDocument();
    }

    public Elements generateElement(Document document){
        return parsingAlgorithm.parsing(document);
    }

}
