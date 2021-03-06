package net.recommenders.evaluation.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Alejandro
 */
public class AbstractLastfmCelmaParser {

    protected boolean useArtists;

    public AbstractLastfmCelmaParser(boolean useArtists) {
        this.useArtists = useArtists;
    }

    public static long getIndexMap(File in, Map<String, Long> map) throws IOException {
        long id = 0;
        if (in.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] toks = line.split("\t");
                long i = Long.parseLong(toks[1]);
                map.put(toks[0], i);
                id = Math.max(i, id);
            }
            br.close();
        }
        return id + 1;
    }
}
