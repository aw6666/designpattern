import org.firstclass.Addition;
import org.firstclass.CalculateFactory;
import org.firstclass.CalculateMethod;
import org.firstclass.Parameter;
import org.junit.Test;
import org.myUtil.ParameterIllegalException;
import org.myUtil.ScanPacket;
import org.w3c.dom.Document;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Demo1{
    @Test
    public void test() throws  ParameterIllegalException {
        CalculateMethod calculateMethod = CalculateFactory.getCalculateFactory().createMethod("+");
        CalculateMethod calculateMethod1 = CalculateFactory.getCalculateFactory().createMethod("+");
        System.out.println(calculateMethod1.hashCode()+" "+calculateMethod.hashCode());
        CalculateMethod calculationMethod = CalculateFactory.getCalculateFactory().createMethod("-");
        Parameter<String> parameter = new Parameter(Arrays.asList("1.23","1.5"));
        System.out.println(calculationMethod.getResult(parameter));
        System.out.println(calculateMethod.getResult(parameter));

    }
    @Test
    public void testAnnotation() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ScanPacket scanPacket = new ScanPacket();
        scanPacket.scanPacket("D:\\idea_workspace\\designpattern\\src\\main\\java\\org\\firstclass");
        System.out.println(scanPacket.getXmlMap());
    }

}