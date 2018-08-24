package com.hik.service;

import java.util.List;

import com.hik.bean.Module;

public interface ModuleService {

	// 添加
	void save(Module module);

	// 删除
	void delete(Integer id);

	// 查询
	List<Module> findAll();
}
