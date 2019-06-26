package com.xbb.service.Impl;

import com.xbb.mapper.ProgramaMapper;
import com.xbb.pojo.Programa;
import com.xbb.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: ProgramaServiceImpl
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000920:35
 */

@Service("programaService")
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaMapper programaMapper;

    /**
     * @description: 加载所有栏目
     * @param
     * @return: java.util.List<com.xbb.pojo.Programa>
     */
    @Override
    public List<Programa> queryProgramaList() {
        return programaMapper.queryProgramaList();
    }
}
