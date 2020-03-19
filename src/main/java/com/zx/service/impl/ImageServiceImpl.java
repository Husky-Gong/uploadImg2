package com.zx.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zx.common.PageInfo;
import com.zx.common.Result;
import com.zx.domain.Image;
import com.zx.form.imageForm;
import com.zx.mapper.ImageMapper;
import com.zx.query.ImageQuery;
import com.zx.service.IImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ImageServiceImpl implements IImagesService {

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public Result queryPage(ImageQuery query) {
        Page<Image> data = PageHelper.startPage(query.getPage(), query.getLimit());
        imageMapper.selectList(query);

        List<Image> list = imageMapper.selectList(query);

        for(Image img:list){
            System.out.println(img);
        }

        PageInfo<Image> pageInfo = new PageInfo<>(data.getResult(),data.getTotal());
        return new Result(pageInfo);
    }

    @Override
    @RequestMapping("upload.do")
    public Result add(@RequestParam("image") MultipartFile img) throws IOException {
        System.out.println("IMG SIZE: "+img.getSize());
        System.out.println("IMG TYPE: "+img.getContentType());
        System.out.println("IMG NAME: "+img.getName());

        String timeDir = DateUtil.format(new Date(),"yyyy-MM-dd");
        String uploadsDir = "/uploads/"+timeDir;
        String realPathUploads = request.getServletContext().getRealPath(uploadsDir);

        if(! new File(realPathUploads).exists()){
            new File(realPathUploads).mkdirs();
        }
        String orgName = img.getOriginalFilename();
        String filePath = realPathUploads+orgName;
        System.out.println(filePath);

        // create image object
        imageForm imgForm = new imageForm();
        imgForm.setName(img.getName());
        imgForm.setSize(img.getSize()+"kb");
        imgForm.setPath(filePath);

        imageMapper.insert(imgForm);

        File dest = new File(filePath);
        img.transferTo(dest);

        return new Result();
    }
}
