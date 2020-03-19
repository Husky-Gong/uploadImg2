package com.zx.service;

import com.zx.common.Result;
import com.zx.query.ImageQuery;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImagesService {
    Result queryPage(ImageQuery query);

    Result add(MultipartFile image) throws IOException;
}
