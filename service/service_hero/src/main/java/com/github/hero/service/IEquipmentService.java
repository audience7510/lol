package com.github.hero.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.hero.pojo.Subject;
import com.github.hero.pojo.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEquipmentService extends IService<Subject> {
    void addSubject(MultipartFile file, IEquipmentService equipmentService);

    List<OneSubject> getAllOneTwoSubject();
}
