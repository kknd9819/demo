package com.zz.demo.service.impl;

import com.zz.demo.model.Clazz;
import com.zz.demo.repository.ClazzRepository;
import com.zz.demo.service.ClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ClazzServiceImpl implements ClazzService {

    @Resource
    private ClazzRepository clazzRepository;

    @Override
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }
}
