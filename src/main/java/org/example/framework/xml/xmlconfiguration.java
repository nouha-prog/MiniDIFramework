package org.example.framework.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "configuration")
public class XmlConfiguration {

    private List<XmlDependency> dependencies;

    @XmlElement(name = "dependency")
    public List<XmlDependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<XmlDependency> dependencies) {
        this.dependencies = dependencies;
    }
}
