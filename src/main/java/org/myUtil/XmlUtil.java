package org.myUtil;

import org.firstclass.CalculateMethod;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

public class XmlUtil {
    public static Object getBean(File file){
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            NodeList nodeList = document.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            String className = node.getLocalName();

            Class cLass = Class.forName(className);
            Object obj = cLass.newInstance();
            return obj;

        }catch (Exception exception){
            System.err.println("读取失败");
            return null;
        }
    }
    public static XmlMap getMethod(){
        File file = new File("D:\\idea_workspace\\designpattern\\src\\main\\resources\\config.xml");
        XmlMap xmlMap = new XmlMap();
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            Element root = document.getDocumentElement();

            NodeList nodeList1 = document.getElementsByTagName("calculateString");
            NodeList nodeList = document.getElementsByTagName("className");
            for(int index = 0; index < nodeList.getLength(); index++){
                String string = "org.firstclass."+nodeToString(nodeList.item(index));
                Class className = Class.forName(string);
                CalculateMethod calculateMethod = (CalculateMethod) className.newInstance();
                xmlMap.put(nodeToString(nodeList1.item(index)),calculateMethod);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return xmlMap;
    }
    private static String nodeToString(Node node) throws Exception{
        StringWriter sw = new StringWriter();
        String res = "";
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(node), new StreamResult(sw));
        for(int i = 0; i < sw.toString().length(); i++){
            if(sw.toString().charAt(i) == '>'){
                i++;
                while(sw.toString().charAt(i) != '<'){
                    res += sw.toString().charAt(i);
                    i++;
                }
                return res;
            }
        }
        return res;
    }
}
