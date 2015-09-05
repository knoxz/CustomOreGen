package de.knoxz.oregenanything.configuration;

import com.google.gson.Gson;
import de.knoxz.oregenanything.utility.LogHelper;
import de.knoxz.oregenanything.utility.Replacer;
import net.minecraftforge.common.config.Configuration;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Dome on 30.09.2014.
 */
public class ConfigurationHandler {

    public static ArrayList<Replacer> repl;
    public static void init(File configFile){

        String configValue = "";
        repl = new ArrayList<Replacer>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("config/oreGen.json"));
            LogHelper.debug("Loading Config");
            repl = new ArrayList<Replacer>();
            Gson gson = new Gson();

            String line = br.readLine();

            while (line != null) {
                LogHelper.info("LINE ADD:" + line);
                repl.add(gson.fromJson(line, Replacer.class));
                line = br.readLine();
            }

        } catch (Exception e) {
            LogHelper.debug("oreGen.json could not be loaded. Maybe it is missing?");
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
