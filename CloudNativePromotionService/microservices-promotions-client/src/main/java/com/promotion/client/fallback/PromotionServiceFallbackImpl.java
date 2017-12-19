package com.promotion.client.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.promotion.client.PromotionService;
import com.promotion.model.Promotion;

@Component
public class PromotionServiceFallbackImpl implements PromotionService{

	@Override
	public Promotion getSamplePromotionById(String promotionId) {
		Promotion promotion = new Promotion();
		return promotion;
	}

	@Override
	public List<Promotion> getItemLevelPromotionsByUserId(String userId, boolean active) {
		return new ArrayList<>();
	}

	@Override
	public Promotion getPromotionById(String promotionId) {
		Promotion promotion = new Promotion();
		return promotion;
	}

	@Override
	public List<Promotion> getALLPromotions() {
		return new ArrayList<>();
	}

}
