package com.alex.util;



import org.apache.commons.httpclient.methods.PostMethod;

import java.io.File;
import java.util.List;

/**
 * Created by chunyan.hcy on 2018/2/6.
 */
public class PostMethodExt {
    private PostMethod postMethod;
    private List<File> fileList;

    public PostMethod getPostMethod() {
        return postMethod;
    }

    public void setPostMethod(PostMethod postMethod) {
        this.postMethod = postMethod;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
