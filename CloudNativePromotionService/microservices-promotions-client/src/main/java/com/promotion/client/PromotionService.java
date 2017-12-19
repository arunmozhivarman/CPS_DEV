package com.promotion.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.promotion.client.fallback.PromotionServiceFallbackImpl;
import com.promotion.model.Promotion;


@FeignClient(value="promotions", fallback=PromotionServiceFallbackImpl.class)
public interface PromotionService {

	@RequestMapping(value = "/promotions/getSamplePromotionById/{promotionId}")
	@ResponseBody
	Promotion getSamplePromotionById(@PathVariable(name = "promotionId") String promotionId);
	
	
	@RequestMapping(value = "/promotions/getItemLevelPromotionByUserId/{userId}/{active}")
	@ResponseBody
	List<Promotion> getItemLevelPromotionsByUserId(@PathVariable(name = "userId") String userId,@PathVariable(name = "active") boolean active);
	

	@RequestMapping(value = "/promotions/getPromotionById/{promotionId}")
	@ResponseBody
	Promotion getPromotionById(@PathVariable(name="promotionId") String promotionId);
		
	@RequestMapping(value = "/getALLPromotions")
	@ResponseBody
	List<Promotion> getALLPromotions();
}
