#依赖注入和控制反转示例
###依赖注入改进计算器
```xml
<?xml version="1.0"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="org/firstclass/config.xml"
           xmlns=""
           elementFormDefault="qualified">

    <xs:element name="Box">
        <xs:complexType>
            <xs:all>
                <xs:element name="CalculateMethod" type="xs:string"/>
            </xs:all>
        </xs:complexType>
    </xs:element>
    <xs:element name="CalculateMethod">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="calculateString" type="xs:string"/>
                <xs:element name="className" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

</xs:schema>
```
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<Box>
    <CalculateMethodIoC>
        <calculateString>+</calculateString><className>Addition</className>
    </CalculateMethodIoC>
    <CalculateMethodIoC>
        <calculateString>-</calculateString><className>Subtraction</className>
    </CalculateMethodIoC>
</Box>
```
通过xml文件来增加类的关联


