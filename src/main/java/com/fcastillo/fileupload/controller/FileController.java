package com.fcastillo.fileupload.controller;

import com.fcastillo.fileupload.entity.Logotipo;
import com.fcastillo.fileupload.service.LogotipoService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value = "/file")
@CrossOrigin(value = "*")
public class FileController {

    @Autowired
    private LogotipoService logotipoService;

    @PostMapping(value = "/upload")
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file) {

        Logotipo storeFile = logotipoService.storeFile(file);
        Map<String, Object> response = new HashMap<>();
        response.put("response", "Ok");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Load file from database
        Logotipo dbFile = logotipoService.getFile(fileId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getTipo())).body(new ByteArrayResource(dbFile.getImagen()));
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFile.getTipo()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getNombre() + "\"")
//                .body(new ByteArrayResource(dbFile.getImagen()));
    }

}
