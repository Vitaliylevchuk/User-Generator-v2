package com.fbs;

import com.fbs.data.ParsingAlgorithm;
import com.fbs.data.People;
import com.fbs.data.Website;
import com.fbs.util.Parser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Generator generator = new Generator(
                ParsingAlgorithm.name_generator_orgAlgorithm,
                new Parser(Website.name_generator_org){
                    @Override
                    public void initConnectParameters() {
                        super.initConnectParameters();
                        setTimeout(0);
                    }
                },
                false);
        People people = generator.generatePeople(120, 190, 30, 130, 0, 90);
        System.out.println(people);
    }

}
