package com.hik.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hik.bean.GroupInfoVO;
import com.hik.service.GroupService;
@RestController
public class GroupController {
@Autowired
private GroupService groupService;
	// 根据id查询项目
	@PostMapping("group/selectgroupById")
	public List<GroupInfoVO>selectgroupById(Integer groupId) {
		List<GroupInfoVO> list = groupService.selectgroupById(groupId);
		return list;
	}
}
