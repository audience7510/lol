package com.github.hero.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.hero.mapper.EquipmentMapper;
import com.github.hero.pojo.EquipmentSubject;
import com.github.hero.pojo.SubjectData;
import com.github.hero.service.IEquipmentService;
import com.github.hero.utils.SubjectExcelListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, EquipmentSubject> implements IEquipmentService {
    @Override
    public void addSubject(MultipartFile file, IEquipmentService equipmentService) {
        try {
            //文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(equipmentService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
