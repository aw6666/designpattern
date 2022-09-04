package org.firstclass;

import org.myUtil.XmlMap;
import org.myUtil.XmlUtil;

public class CalculateFactory{
    private static XmlMap xmlMap ;
    private static CalculateFactory calculateFactory;
    private CalculateFactory(){

    }
    public static CalculateFactory getCalculateFactory(){
        if(calculateFactory == null){
            synchronized (CalculateFactory.class){
                if(calculateFactory == null){
                    calculateFactory = new CalculateFactory();
                    setXmlMap();
                }
            }
        }
        return calculateFactory;
    }
    public CalculateMethod createMethod(String operate){
        return xmlMap.get(operate);
    }

    static void setXmlMap() {
        CalculateFactory.xmlMap = XmlUtil.getMethod();
    }
}
