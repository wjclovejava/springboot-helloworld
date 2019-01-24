package com.wjclovejava.springsecurity.web.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/21 16:31
 */
@RestController
public class FileController {

    private  String path = "D:\\git\\spring-security\\src\\main\\java\\com\\wjclovejava\\springsecurity\\web\\controller";

    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/file")
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(path,System.currentTimeMillis()+".txt");

        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    /**
     * 文件下载
     * @param id
     * @param request
     * @param response
     */
    @GetMapping("/file/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try(InputStream inputStream=new FileInputStream(new File(path,id+".txt"));
                OutputStream outputStream=response.getOutputStream())
        {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }catch (Exception e){

        }
    }

}
