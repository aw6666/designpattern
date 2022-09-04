package org.firstclass;

import org.myUtil.ParameterIllegalException;
import org.secondclass.myannotation.CalculationMethod;

@CalculationMethod
public class Subtraction implements CalculateMethod{
    @Override
    public Double getResult(Parameter parameter) throws ParameterIllegalException {
        if(parameter.size() < 2){
            throw new ParameterIllegalException("缺少参数");
        }
        return Double.parseDouble((String) parameter.get(0)) - Double.parseDouble((String) parameter.get(1));
    }
}
