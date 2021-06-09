package com.fcastillo.fileupload.service;

import com.fcastillo.fileupload.entity.Logotipo;
import com.fcastillo.fileupload.repository.LogotipoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class LogotipoService {

    @Autowired
    private LogotipoRepository logotipoRepository;

    public Logotipo storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Logotipo logo = new Logotipo(fileName, file.getContentType(), file.getBytes());
            return logotipoRepository.save(logo);
        } catch (Exception e) {
            return null;
        }
    }

    public Logotipo getFile(Long id) {
       // logotipoRepository.findById()
        return logotipoRepository.findById(id).get();
    }

}
