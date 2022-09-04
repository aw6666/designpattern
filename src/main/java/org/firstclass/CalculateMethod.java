package org.firstclass;

import org.myUtil.ParameterIllegalException;

import java.util.ArrayList;
import java.util.List;

public interface CalculateMethod {
    /**
     * 细节依赖于抽象，不同计算方法的细节都不同，都会得到一个结果
     * @param parameter
     * @return
     */
    public Double getResult(Parameter parameter) throws ParameterIllegalException;
}
