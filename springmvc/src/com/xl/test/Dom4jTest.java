package com.xl.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {

    @Test
    public void test1() throws Exception {
        //创建一个SAXReader输入流，去读取xml
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/test.xml");

        System.out.println(document);

    }

    /**
     * 读取 books.xml文件
     */

    @Test
    public void test2() throws Exception {

        //1: 读取books.xml文件
        SAXReader saxReader = new SAXReader();

        //2: 通过Document对象获取元素
        Document document = saxReader.read("src/com/xl/test/test.xml");
        Element rootElement = document.getRootElement();

        //3: 通过根元素获取book标签对象
        List<Element> books = rootElement.elements("book");

        for (Element book : books){
            //asXML() 把标签对象转换为标签字符串
            Element name = book.element("name");
            System.out.println(name.asXML());
            System.out.println(name.getText());
        }

        //4: 遍历，处理每个book标签转换为Book类


    }
}
