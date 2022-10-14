package data;

import models.Element;

import java.util.ArrayList;

public class ElementList {

    //TODO - remake to fit like the rest of the lists

    private static final ArrayList<Element> allElements = new ArrayList<>() {
        {
            add(new Element("Dark"));
            add(new Element("Light"));
            add(new Element("Infernal"));
            add(new Element("Burning"));
            add(new Element("Freezing"));
            add(new Element("Divine"));
            add(new Element("Blight"));
            add(new Element("Mortal"));
            add(new Element("Phantom"));
        }
    };

    public static ArrayList<Element> getAll() {
        return allElements;
    }

    public static Element get(String name) {
        while(true) {
            for(Element element : allElements) {
                if (name == element.getName()) {
                    return element;
                }
            }
            name = "Mortal";
        }
    }

    public static ArrayList<Element> multi(String name) {
        ArrayList<Element> list = new ArrayList<>();
        for (Element element : allElements) {
            if (name.contains(element.getName())) {
                list.add(element);
            }
        }
        return list;
    }
}
