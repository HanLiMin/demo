package com.moontwon.demo.spring.entry;

import com.sun.beans.editors.BooleanEditor;
import lombok.Data;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/28
 */
@Data
public class Tree {
    private String name;

    public static void main(String[] args) {
        Boolean a=null;
        BooleanEditor booleanEditor = new BooleanEditor();
        booleanEditor.setValue(a);
        System.err.println(booleanEditor.getValue());
        booleanEditor.setAsText("false");
        System.err.println(booleanEditor.getValue());
        booleanEditor.setAsText("true");
        System.err.println(booleanEditor.getValue());
    }
}
