package com.promotion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.promotion.model.Promotion;

public interface PromotionRepository extends MongoRepository<Promotion, String>  {

	public List<Promotion> getPromotionByUserId(String userId); 
	public List<Promotion> getPromotionByUserIdAndActive(String userId,boolean active); 
	public List<Promotion> getPromotionByUserIdAndTypeAndActive(String userId,int type,boolean active); 
}
