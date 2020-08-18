package com.promotion;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.promotion.model.Promotion;
import com.promotion.repository.PromotionRepository;


@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/promotions")
public class PromotionMicroservice {
	private static final Logger LOGGER = LoggerFactory.getLogger(PromotionMicroservice.class);

	@Autowired
	PromotionRepository promotionRepository;

	@RequestMapping(value = "/getPromotionById/{promotionId}")
	@ResponseBody
	public Promotion getPromotionById(@PathVariable String promotionId){
		Optional<Promotion> promotion = promotionRepository.findById(promotionId);
		return promotion.isPresent() ? promotion.get() : null;
	}

	@RequestMapping(value = "/getALLPromotions")
	@ResponseBody
	public List<Promotion> getALLPromotions(){
		return promotionRepository.findAll();
	}
	
	
	@RequestMapping(value = "/getItemLevelPromotionByUserId/{userId}/{active}")
	@ResponseBody
	public List<Promotion> getItemLevelPromotionsByUserId(@PathVariable String userId,@PathVariable boolean active) throws Exception{
			return promotionRepository.getPromotionByUserIdAndTypeAndActive(userId,0,active);
	}

	@RequestMapping(value = "/getSamplePromotionById/{promotionId}")
	public Promotion getSamplePromotionById(@PathVariable String promotionId){
		LOGGER.info("*************** promotionId"+promotionId);
		if (!"123".equalsIgnoreCase(promotionId)){
			return null;
		}
		Promotion promotion = new Promotion();
		promotion.setId("123");
		promotion.setName("sample promotion");
		return promotion;
	}

	@RequestMapping(value = "/addPromotion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean addPromotion(@RequestBody Promotion promotion){
		if(promotion == null){
			LOGGER.info("promotion null");
			return false;
		}
		LOGGER.info("promotion name : "+promotion.getName());
		promotionRepository.save(promotion);
		return true;
	}

	public static void main(String[] args) {
		SpringApplication.run(PromotionMicroservice.class, args);
	}

}
