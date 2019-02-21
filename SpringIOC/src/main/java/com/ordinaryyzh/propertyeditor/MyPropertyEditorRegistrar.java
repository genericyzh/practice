package com.ordinaryyzh.propertyeditor;

import com.ordinaryyzh.domain.Point;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author OrdinaryYZH
 * @date 2019/2/21 21:18
 */
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        //将自己所定义的PropertyEditor注册到PropertyEditorRegistry中
        registry.registerCustomEditor(Point.class, new PointEditor());
    }
}
