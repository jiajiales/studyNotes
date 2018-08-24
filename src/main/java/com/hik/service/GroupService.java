package com.hik.service;

import java.util.List;
import com.hik.bean.GroupInfoVO;

public interface GroupService {
	List<GroupInfoVO> selectgroupById(Integer groupId);

}
