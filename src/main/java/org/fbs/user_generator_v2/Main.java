package org.fbs.user_generator_v2;

import org.fbs.user_generator_v2.data.ParsingAlgorithm;
import org.fbs.user_generator_v2.data.Website;
import org.fbs.user_generator_v2.util.Parser;

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
        System.out.println(generator.generatePeople(0, 1, 0, 1, 0, 1).getId());
    }

}
