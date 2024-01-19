package com.zzm.controller;

import com.zzm.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("文件上传：{}, {}, {}", username, age, image);

        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();

        // 构造唯一的文件名 (不能重复) - uuid(通用唯一识别码) e8ce1104-2bc7-4f27-850f-26d6df7bbc7c
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID() + extname;
        log.info("新的文件名：{}", newFileName);

        // 将文件存储在服务器的做盘目录中 D:\Workspace\image
        image.transferTo(new File("D:\\Workspace\\image\\" + newFileName));

        return Result.success();
    }
}
