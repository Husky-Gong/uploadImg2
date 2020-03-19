package com.zx.mapper;

import com.zx.domain.Image;
import com.zx.form.imageForm;
import com.zx.query.ImageQuery;

import java.util.List;

public interface ImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(imageForm record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);

    List<Image> selectList(ImageQuery query);
}