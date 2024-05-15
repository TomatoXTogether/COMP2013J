package com.example.test;


import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

/**
 * Checkbox服务组件
 * @author wjz
 *
 */
public class Checkbox {
    /**
     * Checkbox组件
     */
    CheckBox checkbox=new CheckBox();

    /**
     *
     * @return 返回 checkbox
     */
    public ObservableValue<CheckBox> getCheckBox()
    {
        return new  ObservableValue<CheckBox>() {
            /**
             * 添加监听
             */
            @Override
            public void addListener(ChangeListener<? super CheckBox> listener) {
            }
            /**
             * 移除监听
             */
            @Override
            public void removeListener(ChangeListener<? super CheckBox> listener) {

            }
            /**
             * 获取CheckBox
             */
            @Override
            public CheckBox getValue() {
                return checkbox;
            }
            /**
             * 添加监听
             */
            @Override
            public void addListener(InvalidationListener listener) {

            }
            /**
             * 移除监听
             */
            @Override
            public void removeListener(InvalidationListener listener) {

            }
        };
    }
    /**
     * 判读是否已经选中
     * @return
     */
    public Boolean isSelected()
    {
        return checkbox.isSelected();
    }
}
