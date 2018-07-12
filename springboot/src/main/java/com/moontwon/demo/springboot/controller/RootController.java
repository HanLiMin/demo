package com.moontwon.demo.springboot.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-3-17
 */
@Controller
public class RootController {
    @GetMapping({"/", ""})
    public String index() {
        return "hello";
    }


    @PostMapping("/upload")
    public ResponseEntity upload(MultipartFile multipartFile) throws IOException {
        File dir = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "vidio");
        String name = multipartFile.getName();
        File file = new File(dir, name);
        IOUtils.copy(multipartFile.getInputStream(), new BufferedOutputStream(new FileOutputStream(file)));
        return ResponseEntity.ok().build();
    }
}
