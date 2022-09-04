package org.firstclass;

import java.util.*;

/**
 * 参数用于计算的参数集合
 */
public class Parameter<String> extends ArrayList<String> {
    public Parameter(){
        super();
    }
    public Parameter(Collection<? extends String> collection){
        super(collection);
    }
}
