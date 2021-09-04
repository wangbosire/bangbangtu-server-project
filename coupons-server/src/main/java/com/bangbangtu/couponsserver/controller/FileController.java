package com.bangbangtu.couponsserver.controller;


import com.bangbangtu.couponscore.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件 Controller
 *
 * @author Administrator
 */
@Api(tags = "有关文件处理接口")
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public Result<Object> upload(@RequestParam("file") MultipartFile file) {
        return Result.error(file);
    }
}
