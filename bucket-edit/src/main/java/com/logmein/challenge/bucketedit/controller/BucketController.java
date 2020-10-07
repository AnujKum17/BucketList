package com.logmein.challenge.bucketedit.controller;

import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logmein.challenge.bucketedit.api.IBucketApi;
import com.logmein.challenge.bucketedit.exception.handlers.ValidationHelper;
import com.logmein.challenge.bucketedit.model.Item;
import com.logmein.challenge.bucketedit.model.OrderItem;
import com.logmein.challenge.bucketedit.service.IBucketService;

@RestController
@RequestMapping(value="/bucket")
public class BucketController implements IBucketApi {
    @Autowired
    private IBucketService bucketService;
    private static final Logger log = LoggerFactory.getLogger(BucketController.class);

    @PostMapping("/add/item")
    public ResponseEntity<UUID> addItem(@Valid @RequestBody OrderItem orderItemDTO){
        ValidationHelper.validateRequestForAddItem(orderItemDTO);
        return new ResponseEntity<UUID>(bucketService.addItemToBucket(orderItemDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modify/item")
    public ResponseEntity<String> modifyItem(@Valid @RequestBody OrderItem orderItemDTO) {
        ValidationHelper.validateRequestForModifyItem(orderItemDTO);
        bucketService.modifyItemInBucket(orderItemDTO);
        return new ResponseEntity<String>("Item of an user bucket modified.",HttpStatus.OK);
    }

    @DeleteMapping("/delete/user/{userID}/item/{itemID}")
    public ResponseEntity<String> deleteItem(@NotNull @PathVariable String userID,@NotNull @PathVariable UUID itemID){
       ValidationHelper.validateUserID(userID,ValidationHelper.EMPTY_USER_ID);
       ValidationHelper.validateItemID(itemID,ValidationHelper.EMPTY_ITEM_ID);
       bucketService.deleteItemInBucket(userID, itemID);
       return new ResponseEntity<String>("Item deleted from the user bucket list.",HttpStatus.OK);
    }
    
    @GetMapping("/get/items/{userID}")
    public ResponseEntity<Set<Item>> getItems(@NotNull @PathVariable String userID){
       ValidationHelper.validateUserID(userID,ValidationHelper.EMPTY_USER_ID);
       return new ResponseEntity<Set<Item>>(bucketService.getItemsOfBucket(userID), HttpStatus.OK);
    }
}
