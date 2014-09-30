package de.knoxz.customoregen.configuration;

import com.google.gson.Gson;
import de.knoxz.customoregen.utility.LogHelper;
import de.knoxz.customoregen.utility.Replacer;
import net.minecraftforge.common.config.Configuration;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Dome on 30.09.2014.
 */
public class ConfigurationHandler {

    public static ArrayList<Replacer> repl;
    public static void init(File configFile){
        Configuration configuration = new Configuration(configFile);

        String configValue = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("config/oreGen.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            configuration.load();
            LogHelper.info("LOAD");
            configValue = configuration.get(Configuration.CATEGORY_GENERAL, "JsonFileName", "config/oreGen.json", "This is the jsonFilePath").getString();
            LogHelper.debug(configValue);
            repl = new ArrayList<Replacer>();
            Gson gson = new Gson();
            br = new BufferedReader(new FileReader(configValue));

            String line = br.readLine();

            while (line != null) {
                LogHelper.info("LINE ADD:" + line);
                repl.add(gson.fromJson(line, Replacer.class));
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            configuration.save();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
