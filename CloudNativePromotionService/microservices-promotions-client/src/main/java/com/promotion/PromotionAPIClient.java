package com.promotion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.promotion.client.PromotionService;
import com.promotion.model.Promotion;
import com.promotion.model.Promotions;


@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RequestMapping("/promotionsclient")
public class PromotionAPIClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(PromotionAPIClient.class);

	private PromotionService promotionService;

	@RequestMapping(value = "/getALLPromotions")
	@ResponseBody
	public Promotions getPromotionById(){
		Promotions promotions = new Promotions();
		promotions.setPromotions( getPromotionService().getALLPromotions());
		return promotions;
	}
	
	@RequestMapping(value = "/getPromotionSampleById/{promotionId}")
	@ResponseBody
	public Promotion getPromotionsampleById(@PathVariable String promotionId){
		return getPromotionService().getSamplePromotionById(promotionId);
	}


	@RequestMapping(value = "/getActivePromotionList/{userId}")
	@ResponseBody
	public Promotions getActivePromotionList(@PathVariable String userId){
		Promotions promotions = new Promotions();
		List<Promotion> itemLevelPromotionsByUserId = getPromotionService().getItemLevelPromotionsByUserId(userId, true);
		promotions.setPromotions(itemLevelPromotionsByUserId); ;
		return promotions;
	}

	@RequestMapping(value = "/getPromotionById/{promotionId}")
	@ResponseBody
	public Promotion getPromotionById(@PathVariable String promotionId){
		 return getPromotionService().getPromotionById(promotionId);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PromotionAPIClient.class, args);
	}

	public PromotionService getPromotionService() {
		return promotionService;
	}

	@Autowired
	public void setPromotionService(PromotionService promotionService) {
		this.promotionService = promotionService;
	}

}
