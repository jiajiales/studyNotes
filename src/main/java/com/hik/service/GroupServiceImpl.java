package com.hik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hik.bean.GroupInfoVO;
import com.hik.mapper.GroupMapper;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupMapper roupServiceMapper;

	@Override
	public List<GroupInfoVO> selectgroupById(Integer groupId) {
		return roupServiceMapper.selectgroupById(groupId);
	}

}
