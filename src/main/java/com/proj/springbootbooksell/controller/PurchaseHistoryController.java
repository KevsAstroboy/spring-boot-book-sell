package com.proj.springbootbooksell.controller;

import com.proj.springbootbooksell.model.PurchaseHistory;
import com.proj.springbootbooksell.security.UserPrincipal;
import com.proj.springbootbooksell.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase-history")
public class PurchaseHistoryController {

       @Autowired
       IPurchaseHistoryService purchaseHistoryService;

       @PostMapping
       public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){

              return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
       }
       @GetMapping
       public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){

              return new ResponseEntity<>(purchaseHistoryService.findPurchasedItemsOfUser(userPrincipal.getId()),HttpStatus.OK);
       }
}
