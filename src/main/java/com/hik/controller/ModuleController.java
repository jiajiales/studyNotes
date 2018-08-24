package com.hik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hik.bean.Module;
import com.hik.service.ModuleService;

@RestController
public class ModuleController {
	@Autowired
	private ModuleService moduleService;

	// 添加
	@GetMapping("/save")
	public void save() {
		Module module = new Module();
		module.setTname("减肥");
		this.moduleService.save(module);
	}

	// 删除
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		this.moduleService.delete(id);
	}

	// 查询所有
	@GetMapping("/findAll")
	public List<Module> findAll() {
		return this.moduleService.findAll();

	}
}
