package org.firstclass;

import org.myUtil.ParameterIllegalException;
import org.myUtil.XmlUtil;

import java.util.List;

public class Calculator {
    private CalculateMethod calculateMethod;
    private Parameter parameters;

    /**
     * 高层模块应该依赖于抽象
     * @param calculateMethod
     * @param parameter
     */
    public Calculator(CalculateMethod calculateMethod, Parameter parameter){
        this.calculateMethod = calculateMethod;
        this.parameters = parameter;
    }
    public Double selectCalculate(String str, Parameter parameter) throws ParameterIllegalException {
        CalculateMethod calculateMethod = CalculateFactory.getCalculateFactory().createMethod(str);
        return calculateMethod.getResult(parameter);
    }
}
