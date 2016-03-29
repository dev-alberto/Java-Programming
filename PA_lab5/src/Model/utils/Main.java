package com.company;

import java.io.File;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Main {
    final static String propriety1 = "Path";
    final static String propriety2 = "Mark";
    final static String fileName = "favSong.xml";
    private static Element CreateSongElement(Document document, FavouriteSong song){
        Element newSong = document.createElement("song");

        Element name = document.createElement(propriety1);
        name.appendChild(document.createTextNode(song.getPath()));
        newSong.appendChild(name);

        Element port = document.createElement(propriety2);
        port.appendChild(document.createTextNode(song.getMark()));
        newSong.appendChild(port);

        return newSong;
    }

    public static void add(FavouriteSong favouriteSong) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document;
        try {
            document = documentBuilder.parse(fileName);
        }catch (Exception e) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            document = builder.newDocument();
        }

        Element root = document.getDocumentElement();
        Element newSong = CreateSongElement(document, favouriteSong);
        if (root != null) {
                root.appendChild(newSong);
        }
        else {
            Element x = document.createElement("favouriteSongs");
            document.appendChild(x);
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes") ;
        StreamResult result = new StreamResult(fileName);
        transformer.transform(source, result);
    }

    public static List<FavouriteSong> deserialize(String argv[]) {
        List<FavouriteSong> favouriteSongs =  new ArrayList<>();

        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("song");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode =  nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    favouriteSongs.add(
                            new FavouriteSong(eElement.getElementsByTagName(propriety1).item(0).getTextContent(),
                            "Staff id : " + eElement.getElementsByTagName(propriety2).item(0).getTextContent()));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return favouriteSongs;
    }


    public static class FavouriteSong {
        FavouriteSong(String a, String b){}
        public String getPath() { return "1"; }
        public String getMark() { return "0"; }
    }
}