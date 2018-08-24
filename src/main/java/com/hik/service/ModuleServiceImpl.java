package com.hik.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hik.bean.Module;
import com.hik.repository.ModuleRepository;
@Service
public class ModuleServiceImpl implements ModuleService {
	 // @Resource是根据名称注入 @Autowired是根据类型注入
    @Resource
    private ModuleRepository moduleRepository;
    //添加
    @Override
    public void save(Module target) {
        this.moduleRepository.save(target);
    }

    //删除
    @Override
    public void delete(Integer id) {
        this.moduleRepository.deleteById(id);
    }

    //查询
    @Override
    public List<Module> findAll(){
        return (List<Module>) this.moduleRepository.findAll();
    }

}
