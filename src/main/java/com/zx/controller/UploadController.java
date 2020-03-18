package com.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("upload.do")
    public String upload(@RequestParam("img") MultipartFile img,String userName,String password) throws IOException {
        System.out.println("USERNAME: "+userName);
        System.out.println("PASSWORD: "+password);
        System.out.println("IMG SIZE: "+img.getSize());
        System.out.println("IMG TYPE: "+img.getContentType());
        System.out.println("IMG NAME: "+img.getName());
        String uploadsDir = "/uploads/";
        String realPathUploads = request.getServletContext().getRealPath(uploadsDir);

        if(! new File(realPathUploads).exists()){
            new File(realPathUploads).mkdir();
        }

        String orgName = img.getOriginalFilename();
        String filePath = realPathUploads+orgName;

        System.out.println(filePath);

        File dest = new File(filePath);

        img.transferTo(dest);

        return "/index.html";
    }
}
