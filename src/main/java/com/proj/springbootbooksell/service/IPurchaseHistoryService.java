package com.proj.springbootbooksell.service;

import com.proj.springbootbooksell.model.PurchaseHistory;
import com.proj.springbootbooksell.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemsOfUser(Long userId);
}
