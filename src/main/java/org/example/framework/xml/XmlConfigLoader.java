package org.example.framework.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlConfigLoader {
    public static Map<String, String> loadConfig(String filePath) {
        Map<String, String> dependencies = new HashMap<>();
        try {
            JAXBContext context = JAXBContext.newInstance(XmlConfiguration.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            XmlConfiguration config = (XmlConfiguration) unmarshaller.unmarshal(new File(filePath));

            for (XmlConfiguration.Dependency dep : config.getDependencies()) {
                dependencies.put(dep.getId(), dep.getClassName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dependencies;
    }
}

