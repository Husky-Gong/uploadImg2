package com.zx.domain;

public class Image {
    /**
    * id
    */
    private Integer id;

    /**
    * file name
    */
    private String name;

    /**
    * file size
    */
    private String size;

    /**
    * file physical path
    */
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}