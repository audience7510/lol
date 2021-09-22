package com.github.hero.utils;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.hero.common.ResultCode;
import com.github.hero.handler.LolException;
import com.github.hero.pojo.EquipmentSubject;
import com.github.hero.pojo.SubjectData;
import com.github.hero.service.IEquipmentService;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    //因为SubjectExcelListener不能交给spring进行管理，需要自己new，不能注入其他对象
    //不能实现数据库操作
    public IEquipmentService equipmentService;
    public SubjectExcelListener() {}
    public SubjectExcelListener(IEquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    //读取excel内容，一行一行进行读取
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData == null) {
            throw new LolException(ResultCode.NOT_FOUND,"文件数据为空");
        }

        //一行一行读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
        //判断一级分类是否重复
        EquipmentSubject existOneSubject = this.existOneSubject(equipmentService, subjectData.getOneSubjectName());
        if(existOneSubject == null) { //没有相同一级分类，进行添加
            existOneSubject = new EquipmentSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName());//一级分类名称
            existOneSubject.setCreateTime(DateUtil.now());
            equipmentService.save(existOneSubject);
        }

        //获取一级分类id值
        String pid = existOneSubject.getId();

        //添加二级分类
        //判断二级分类是否重复
        EquipmentSubject existTwoSubject = this.existTwoSubject(equipmentService, subjectData.getTwoSubjectName(), pid);
        if(existTwoSubject == null) {
            existTwoSubject = new EquipmentSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());//二级分类名称
            existTwoSubject.setCreateTime(DateUtil.now());
            equipmentService.save(existTwoSubject);
        }
    }

    //判断一级分类不能重复添加
    private EquipmentSubject existOneSubject(IEquipmentService equipmentService,String name) {
        QueryWrapper<EquipmentSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EquipmentSubject oneSubject = equipmentService.getOne(wrapper);
        return oneSubject;
    }

    //判断二级分类不能重复添加
    private EquipmentSubject existTwoSubject(IEquipmentService equipmentService,String name,String pid) {
        QueryWrapper<EquipmentSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EquipmentSubject twoSubject = equipmentService.getOne(wrapper);
        return twoSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
