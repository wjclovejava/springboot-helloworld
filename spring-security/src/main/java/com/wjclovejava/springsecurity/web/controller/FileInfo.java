package com.wjclovejava.springsecurity.web.controller;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/21 16:32
 */
public class FileInfo {


    public String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
