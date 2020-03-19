package com.zx.service;

import com.zx.common.Result;
import com.zx.query.ImageQuery;

public interface IImagesService {
    Result queryPage(ImageQuery query);
}
