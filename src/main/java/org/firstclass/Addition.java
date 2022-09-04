package org.firstclass;

import org.myUtil.ParameterIllegalException;
import org.secondclass.myannotation.CalculationMethod;

import java.lang.annotation.Target;

@CalculationMethod
public class Addition implements CalculateMethod{
    @Override
    public Double getResult(Parameter parameter) throws ParameterIllegalException {
        Double res ;
        if(parameter.size() < 2){
            throw new ParameterIllegalException("缺少参数");
        }
        res = Double.parseDouble((String) parameter.get(0)) + Double.parseDouble((String) parameter.get(1));

        return res;
    }
}
