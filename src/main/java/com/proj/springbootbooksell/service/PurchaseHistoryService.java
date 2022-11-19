package com.proj.springbootbooksell.service;

import com.proj.springbootbooksell.model.PurchaseHistory;
import com.proj.springbootbooksell.repository.IPurchaseHistoryRepository;
import com.proj.springbootbooksell.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{

    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;


    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){

           purchaseHistory.setPurchaseTime(LocalDateTime.now());
           return purchaseHistoryRepository.save(purchaseHistory);
    }
    @Override
    public List<IPurchaseItem> findPurchasedItemsOfUser(Long userId){

           return purchaseHistoryRepository.findAllPurchaseOfUser(userId);
    }

}
