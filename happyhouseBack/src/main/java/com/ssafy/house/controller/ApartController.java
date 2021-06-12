package com.ssafy.house.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.ApartDto;
import com.ssafy.house.dto.AptAvgDto;
import com.ssafy.house.dto.CityDto;
import com.ssafy.house.dto.SearchCondition2;
import com.ssafy.house.service.ApartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//@RequestMapping("/apart")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="house", description="Happy house")
public class ApartController {
	private static final Logger logger = LoggerFactory.getLogger(ApartController.class);
	
	@Autowired
	private ApartService apartService;
	
	@GetMapping(value = "/apart/findAvgDesc/{gugunCode}/{dealYear}")
	public ResponseEntity<List<AptAvgDto>> findAptAvgDesc(@PathVariable("gugunCode") String gugunCode, @PathVariable("dealYear") String dealYear) {
		Map paramMap = new HashMap();
		paramMap.put("gugunCode", gugunCode);
		paramMap.put("dealYear", dealYear);
		List<AptAvgDto> list = apartService.listAptAvgDesc(paramMap);
		return new ResponseEntity<List<AptAvgDto>>(list, HttpStatus.OK);
	}
	@GetMapping(value = "/apart/findAvgAsc/{gugunCode}/{dealYear}")
	public ResponseEntity<List<AptAvgDto>> findAptAvgAsc(@PathVariable("gugunCode") String gugunCode, @PathVariable("dealYear") String dealYear) {
		Map paramMap = new HashMap();
		paramMap.put("gugunCode", gugunCode);
		paramMap.put("dealYear", dealYear);
		List<AptAvgDto> list = apartService.listAptAvgAsc(paramMap);
		return new ResponseEntity<List<AptAvgDto>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "시/도 코드, 명을 반환한다.", response = List.class)
	@GetMapping(value="/apart/sido")
	public ResponseEntity<List<CityDto>> findSiDo(){
		List<CityDto> list = apartService.listSido();
		if (list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CityDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/apart/gu/{cityCode}")
	public ResponseEntity<List<CityDto>> findgu(@PathVariable("cityCode") String cityCode) {
		List<CityDto> list = apartService.listGu(cityCode.substring(0, 2));
		return new ResponseEntity<List<CityDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/apart/dong/{dongCode}")
	public ResponseEntity<List<CityDto>> finddong(@PathVariable("dongCode") String dongCode) {
		List<CityDto> list = apartService.listDong(dongCode.substring(0, 4));
		return new ResponseEntity<List<CityDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/apart/search/{guCode}/{dongCode}")
	public ResponseEntity<List<ApartDto>> search(@PathVariable("guCode") String guCode, @PathVariable("dongCode") String dongCode) {
		List<ApartDto> list = apartService.apartInfo(new ApartDto(dongCode, null, guCode.substring(0, 5), null, null, null));
		return new ResponseEntity<List<ApartDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/apart/searchDetail/{dongCode}/{aptName}/{key}/{word}")
	public ResponseEntity<List<ApartDto>> searchDetail(@PathVariable("dongCode") String dongCode, @PathVariable("aptName") String aptName
			,@PathVariable("key") String key, @PathVariable("word") String word) {
		System.out.println("ddddd");
		List<ApartDto> list = apartService.apartDetail(new SearchCondition2(key, word, dongCode, aptName));
		System.out.println(list.toString());
		return new ResponseEntity<List<ApartDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/apart/searchMain/{searchWord}")
	public ResponseEntity<List<ApartDto>> searchMain(@PathVariable("searchWord") String searchWord) {
		List<ApartDto> list = apartService.apartList(searchWord);
		System.out.println(list.toString());
		return new ResponseEntity<List<ApartDto>>(list, HttpStatus.OK);
	}
	
	
}
