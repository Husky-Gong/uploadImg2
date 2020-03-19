package com.zx.controller;

import com.zx.query.ImageQuery;
import com.zx.service.IImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("file")
public class ImagesController {

    @Autowired
    private IImagesService imagesService;

    @RequestMapping("page.do")
    @ResponseBody
    public Object page(ImageQuery query){
        return imagesService.queryPage(query);
    }

    @RequestMapping("upload.do")
    @ResponseBody
    public Object upload(MultipartFile image) throws IOException {
        return imagesService.add(image);
    }
}
