package com.github.hero.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.hero.pojo.EquipmentSubject;
import org.springframework.web.multipart.MultipartFile;

public interface IEquipmentService extends IService<EquipmentSubject> {
    void addSubject(MultipartFile file, IEquipmentService equipmentService);
}
