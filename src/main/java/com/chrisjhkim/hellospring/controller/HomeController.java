package com.chrisjhkim.hellospring.controller;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chrisjhkim.hellospring.service.QualifierService;
import com.chrisjhkim.hellospring.service.StudyService;
import com.chrisjhkim.hellospring.study.service.PropertyTestWithJavaService;
import com.chrisjhkim.hellospring.study.service.PropertyTestWithXmlService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private Collection<StudyService> studyServiceList;
	@Autowired
	private StudyService[] studyServiceArrays;
	@Autowired
	private Map<String, StudyService> studyServiceMap;

	@Autowired
	@Qualifier("studyFirst")
	private StudyService studyServiceFirst;
	
	@Autowired
	@Qualifier("studyFirst")
	private StudyService studyServiceFirstDup;
	@Autowired
	@Qualifier("studySecond")
	private StudyService studyServiceSecond;

	@Autowired
	@Qualifier("mainQService")
	private QualifierService qualifierService;

	@Autowired
	private PropertyTestWithXmlService propertyTestWithXmlService;
	@Autowired
	private PropertyTestWithJavaService propertyTestWithJavaService;
	/**
	 * Simply selects the home view to render by returning its name.
	 * http://localhost:8080/hellospring/
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		testAutowired();

		testQualifier();
		
		testPropertyTestService();
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	private void testPropertyTestService() {
		// xml bean 등록에서 property 세팅한것이 제대로 프린트 되나 확인
		propertyTestWithXmlService.printInfos();
		
		// Java bean 등록에서 property 세팅한것이 제대로 프린트 되나 확인
		propertyTestWithJavaService.printInfos();
		
		
	}

	private void testQualifier() {
		// TODO Auto-generated method stub
		qualifierService.printClass();

		logger.info("studyServiceFirst    {}", studyServiceFirst);
//		logger.info("studyServiceFirstDup {}", studyServiceFirstDup);
		logger.info("studyServiceSecond   {}", studyServiceSecond);
		
	}

	/**
	 * 인터페이스를 구현한 빈이 두개 이상 존재할때 아래와 같이 Collection , Set, List , 배열 등으로 선언해서 빈들을 DI
	 * 받을 수 있다. 1. 빈 여러개가 충돌하는것을 방지하려고 쓰면 안된다. 2. 빈의 타입이 컬렉션인 경우에는 @Autowired 로
	 * 자동설정이 불가능하다.
	 */
	private void testAutowired() {
		logger.info("collection size = {}", studyServiceList.size());
		Object[] array = studyServiceList.toArray();
		((StudyService) array[0]).print("1");
		((StudyService) array[1]).print("2");

		studyServiceArrays[0].print("array 1");
		studyServiceArrays[1].print("array 2");

		logger.info("Autowired된 service Map = {}", studyServiceMap.toString());

	}

}
