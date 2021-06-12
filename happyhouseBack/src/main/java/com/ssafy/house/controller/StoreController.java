package com.ssafy.house.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.CategoryDto;
import com.ssafy.house.dto.StoreDto;
import com.ssafy.house.help.NumberResult;
import com.ssafy.house.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="house", description="Happy house")
public class StoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreService storeService;
	
//	@ApiOperation(value = "Code(시/군구/동)에 속하는 상점 정보를 반환한다.(페이지당 10개)", response = List.class)
//	@RequestMapping(value = {"/storeList/{currentPage}","/storeList/{currentPage}/{sidoCode}","/storeList/{currentPage}/{sidoCode}/{gugunCode}","/storeList/{currentPage}/{sidoCode}/{gugunCode}/{dongCode}"},method=RequestMethod.GET)
//	public ResponseEntity<List<StoreDto>> searchByCode(@PathVariable int currentPage,@PathVariable(required = false) String sidoCode,@PathVariable(required = false) String gugunCode,@PathVariable(required = false) String dongCode) throws Exception {
//		logger.info("1-------------searchByCode-----------------------------"+new Date());
//		StoreDto store = new StoreDto(sidoCode,gugunCode,dongCode,currentPage,10);
//		List<StoreDto> stores = storeService.searchByCode(store);
//		
//		if (stores.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<StoreDto>>(stores, HttpStatus.OK);
//	}
//	
//	@ApiOperation(value = "Code(시/군구/동)에 속하는 상점 정보의 총 갯수를 반환한다.)", response = List.class)
//	@RequestMapping(value = {"/storeList/getTotalCount/{currentPage}","/storeList/getTotalCount/{currentPage}/{sidoCode}"
//			,"/storeList/getTotalCount/{currentPage}/{sidoCode}/{gugunCode}"
//			,"/storeList/getTotalCount/{currentPage}/{sidoCode}/{gugunCode}/{dongCode}"},method=RequestMethod.GET)
//	public ResponseEntity<Integer> getTotalCount(@PathVariable int currentPage,@PathVariable(required = false) String sidoCode,@PathVariable(required = false) String gugunCode,@PathVariable(required = false) String dongCode) throws Exception {
//		logger.info("1-------------searchByCode-----------------------------"+new Date());
//		StoreDto store = new StoreDto(sidoCode,gugunCode,dongCode,currentPage,10);
//		int tot = storeService.getTotalCount(store);
//		
//		return new ResponseEntity<Integer>(tot, HttpStatus.OK);
//	}
//	
//	@ApiOperation(value = "동네(dongCode)의 카테고리별(category)상점 정보를 반환한다.", response = List.class)
//	@RequestMapping(value = {"/aroundStore/{dongCode}/{category}"},method=RequestMethod.GET)
//	public ResponseEntity<List<StoreDto>> findAroundStore(@PathVariable String category,@PathVariable String dongCode) throws Exception {
//		logger.info("1-------------findAroundStore-----------------------------"+new Date());
//		Map paramMap = new HashMap();
//		paramMap.put("dongCode", dongCode);
//		paramMap.put("smallCategoryCode", category);
//		List<StoreDto> stores = storeService.findAroundStore(paramMap);
//		if (stores.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<StoreDto>>(stores, HttpStatus.OK);
//	}
	
	@ApiOperation(value = "동네(dongCode)의 카테고리별(category)상점 개수를 반환한다.", response = List.class)
	@RequestMapping(value = "/store/count/{gugunCode}/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<StoreDto>> findStoreCount(@PathVariable String gugunCode,@PathVariable String category) throws Exception {
		logger.info("1-------------findAroundStore-----------------------------"+new Date());
		Map paramMap = new HashMap();
		paramMap.put("gugunCode", gugunCode);
		paramMap.put("category", category);
		List<StoreDto> stores = storeService.findStoreCount(paramMap);
		
		if (stores.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<StoreDto>>(stores, HttpStatus.OK);
	}
	
	@ApiOperation(value = "구의(gugun)의 카테고리별(category)상점 개수를 반환한다.", response = NumberResult.class)
	@RequestMapping(value = "/store/{gugunCode}/{category}", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> findGugunStoreCount(@PathVariable String gugunCode,@PathVariable String category) throws Exception {
		logger.info("1-------------findAroundStore-----------------------------"+new Date());
		Map paramMap = new HashMap();
		paramMap.put("gugunCode", gugunCode);
		paramMap.put("category", category);
		int total = storeService.findGugunStoreCount(paramMap);
		NumberResult nr = new NumberResult();
		nr.setCount(total);
   		nr.setName("guguntotal");
   		nr.setState("succ");
		if (total<=0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
	@ApiOperation(value = "구의(gugun)의 카테고리를 반환한다.", response = List.class)
	@RequestMapping(value = "/store/category", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDto>> largeCategory() throws Exception {
		logger.info("1-------------findAroundStore-----------------------------"+new Date());
		List<CategoryDto> category = storeService.largeCategory();
		if (category.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CategoryDto>>(category, HttpStatus.OK);
	}

}
