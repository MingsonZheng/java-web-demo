package com.zzm.controller;

import com.zzm.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) {
        log.info("文件上传：{}, {}, {}", username, age, image);
        return Result.success();
    }
}
