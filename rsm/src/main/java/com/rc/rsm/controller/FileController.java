package com.rc.rsm.controller;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.AliOssUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.UUID;

import static com.ruoyi.common.utils.AliOssUtil.Endpoint;
import static com.ruoyi.common.utils.AliOssUtil.BucketName;

@RestController
@RequestMapping("/rsm/oss")
public class FileController {
    @PostMapping(value = "/upload")
    public AjaxResult upload(MultipartFile file) throws Exception {
        try {
            if (file == null) {
                return AjaxResult.error("上传文件失败");
            }
            // 文件类型校验
            String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif"}; // 允许的文件扩展名
            String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            if (!Arrays.asList(allowedExtensions).contains("." + fileExtension)) {
                return AjaxResult.error("不允许的文件类型");
            }

            // 文件大小校验
            long maxSize = 5 * 1024 * 1024; // 最大文件大小为 5MB
            if (file.getSize() > maxSize) {
                return AjaxResult.error("文件过大，请上传不超过 5MB 的文件");
            }

            // 文件夹
            String folder = "rsm_weixin/";
            // 上传逻辑
            String originalFilename = file.getOriginalFilename();
            // 保证文件的名字是唯一的
            String fileName = folder + UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // file.transferTo(new File("A:\\桌面\\files\\"+fileName));
            String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
            return AjaxResult.success("上传成功", (Object) url);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("上传文件失败：" + e.getMessage());
        }
    }




    @DeleteMapping(value = "/delete")
    public AjaxResult deleteFile(@RequestBody String url) throws Exception {
        // 构建 baseUrl
        String baseUrl = "https://" + BucketName + "." + Endpoint.substring(Endpoint.lastIndexOf("/") + 1) + "/";
        // 解析请求体中的 JSON
        JSON parse = JSONUtil.parse(url);
        String imgUrl = (String) parse.getByPath("url");
        // 移除 baseUrl，得到相对路径
        if (imgUrl != null && imgUrl.startsWith(baseUrl)) {
            imgUrl = imgUrl.replace(baseUrl, "");
        } else {
            return AjaxResult.error("URL 无效或格式不正确");
        }
//        System.out.println(imgUrl);
        String deleteFileMsg = AliOssUtil.deleteFile(imgUrl);
        return AjaxResult.success("操作成功", (Object) deleteFileMsg);
    }
}
