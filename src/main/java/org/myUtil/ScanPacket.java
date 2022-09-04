package org.myUtil;

import org.firstclass.CalculateMethod;
import org.secondclass.myannotation.CalculationMethod;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.Queue;

public class ScanPacket {
    private XmlMap xmlMap = new XmlMap();
    public void scanPacket(String packetPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        File file = new File(packetPath);
        Queue<File> stringQueue = new LinkedList<>();
        stringQueue.add(file);
        while(!stringQueue.isEmpty()){
            int countFile = stringQueue.size();
            if(countFile == 0){
                break;
            }
            for(int i = 0; i < countFile; i++){
                File f = stringQueue.poll();
                System.out.println(f.getName());
                getXmlMapByScan(f);
                File[] files = f.listFiles();
                if(files == null) continue;
                for(File F: files){
                    stringQueue.add(F);
                }
            }
        }
    }
    void getXmlMapByScan(File file) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = file.getName();
        if(className.endsWith(".java")){
            String string = "org.firstclass."+className.replaceAll(".java","");
            Class cla = Class.forName(string);
            Annotation[] annotations = cla.getAnnotations();
            for(Annotation annotation: annotations){
                if(annotation instanceof CalculationMethod){
                    CalculateMethod calculateMethod = (CalculateMethod) cla.newInstance();
                    xmlMap.put(className,calculateMethod);
                }
            }
        }
    }
    public XmlMap getXmlMap() {
        return this.xmlMap;
    }
}
