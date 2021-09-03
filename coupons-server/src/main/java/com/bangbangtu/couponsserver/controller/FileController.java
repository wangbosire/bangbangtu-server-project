package com.bangbangtu.couponsserver.controller;


import com.bangbangtu.couponscore.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public Result<Object> upload(@RequestParam("file") MultipartFile file) {
        return Result.error(file);
    }
}
