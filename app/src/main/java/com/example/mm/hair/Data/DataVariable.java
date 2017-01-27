package com.example.mm.hair.Data;

import java.io.Serializable;

/**
 * Created by mm on 08/01/2017.
 */

public class DataVariable implements Serializable {

    private String Title;
    private int Picture;
    private String Component;
    private String Method;





    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        Component = component;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }
}
