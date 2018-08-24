package com.hik.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hik.bean.GroupInfoVO;

public interface GroupMapper {

	List<GroupInfoVO> selectgroupById(@Param("groupId") Integer groupId);

}
