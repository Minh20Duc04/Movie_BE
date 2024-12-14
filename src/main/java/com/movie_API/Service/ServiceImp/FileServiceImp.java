package com.movie_API.Service.ServiceImp;

import com.movie_API.Service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImp implements FileService {


    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException { // tải file từ chỗ khác xong gán xuống đường dẫn path (path có thể chưa có hoặc tạo sẵn)
        String fileName = file.getOriginalFilename();

        String filePath = path + File.separator + fileName; //mới tạo đường dẫn

        File f = new File(path);
        if(!f.exists())
        {
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath)); // lưu file vào folder

        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String filename) throws FileNotFoundException {
        String filePath = path + File.separator + filename;
        return new FileInputStream(filePath);
    }










}
