/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.aliyuncs.dysmsapi.transform.v20170525;

import java.util.ArrayList;
import java.util.List;

import com.aliyuncs.dysmsapi.model.v20170525.QueryInterSmsIsoInfoResponse;
import com.aliyuncs.dysmsapi.model.v20170525.QueryInterSmsIsoInfoResponse.IsoSupportDTO;
import com.aliyuncs.transform.UnmarshallerContext;


public class QueryInterSmsIsoInfoResponseUnmarshaller {

	public static QueryInterSmsIsoInfoResponse unmarshall(QueryInterSmsIsoInfoResponse queryInterSmsIsoInfoResponse, UnmarshallerContext context) {
		
		queryInterSmsIsoInfoResponse.setRequestId(context.stringValue("QueryInterSmsIsoInfoResponse.RequestId"));
		queryInterSmsIsoInfoResponse.setCode(context.stringValue("QueryInterSmsIsoInfoResponse.Code"));
		queryInterSmsIsoInfoResponse.setMessage(context.stringValue("QueryInterSmsIsoInfoResponse.Message"));

		List<IsoSupportDTO> isoSupportDTOs = new ArrayList<IsoSupportDTO>();
		for (int i = 0; i < context.lengthValue("QueryInterSmsIsoInfoResponse.IsoSupportDTOs.Length"); i++) {
			IsoSupportDTO isoSupportDTO = new IsoSupportDTO();
			isoSupportDTO.setCountryName(context.stringValue("QueryInterSmsIsoInfoResponse.IsoSupportDTOs["+ i +"].CountryName"));
			isoSupportDTO.setCountryCode(context.stringValue("QueryInterSmsIsoInfoResponse.IsoSupportDTOs["+ i +"].CountryCode"));
			isoSupportDTO.setIsoCode(context.stringValue("QueryInterSmsIsoInfoResponse.IsoSupportDTOs["+ i +"].IsoCode"));

			isoSupportDTOs.add(isoSupportDTO);
		}
		queryInterSmsIsoInfoResponse.setIsoSupportDTOs(isoSupportDTOs);
	 
	 	return queryInterSmsIsoInfoResponse;
	}
}