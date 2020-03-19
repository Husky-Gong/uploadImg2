package com.zx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zx.common.PageInfo;
import com.zx.common.Result;
import com.zx.domain.Image;
import com.zx.mapper.ImageMapper;
import com.zx.query.ImageQuery;
import com.zx.service.IImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImagesService {

    @Autowired
    private ImageMapper imageMapper;

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
}
