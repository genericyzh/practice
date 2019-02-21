package com.ordinaryyzh.propertyeditor;

import com.ordinaryyzh.domain.Point;

import java.beans.PropertyEditorSupport;

/**
 * @author OrdinaryYZH
 * @date 2019/2/21 21:17
 */
public class PointEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] splits = text.split(";");
        Point point = new Point();
        point.setX(Integer.parseInt(splits[0]));
        point.setY(Integer.parseInt(splits[1]));
        /*
         *需要将装换后的结果设置到Editor的value属性中，因为外部会通过getValue获取到转换的结果。
         */
        setValue(point);
    }
}
