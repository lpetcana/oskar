package org.oskar.repository;


import org.apache.commons.logging.Log;
import org.oskar.model.Wig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyRepository {

    private static Logger LOGGER = LoggerFactory.getLogger(DummyRepository.class);
    private List<Wig> wigsList;

    @EventListener(ContextRefreshedEvent.class)
    public void populateWigs() {
        wigsList = new ArrayList<>();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("data.csv").getFile());

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String cvsSplitBy = ",";

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] wigRow = line.split(cvsSplitBy);
                Wig readWig = null;

                if (wigRow.length == 5) {
                    readWig = new Wig(wigRow[0], wigRow[1], wigRow[2], wigRow[3], wigRow[4]);
                }
                if (wigRow.length == 4) {
                    readWig = new Wig(wigRow[0], wigRow[1], wigRow[2], wigRow[3]);
                }
                if (readWig != null)
                    wigsList.add(readWig);
            }
            LOGGER.info("Finished reading data.csf file!");

        } catch (Exception ex) {
            LOGGER.error("error reading the file data.csv!");
        }
    }

    public List<Wig> getWigsList() {
        return wigsList;
    }

}
