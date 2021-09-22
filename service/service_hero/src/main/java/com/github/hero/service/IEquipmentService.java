package com.github.hero.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.hero.pojo.EquipmentSubject;
import com.github.hero.pojo.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEquipmentService extends IService<EquipmentSubject> {
    void addSubject(MultipartFile file, IEquipmentService equipmentService);

    List<OneSubject> getAllOneTwoSubject();
}
