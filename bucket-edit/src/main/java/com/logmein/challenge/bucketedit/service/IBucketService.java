package com.logmein.challenge.bucketedit.service;

import java.util.Set;
import java.util.UUID;

import com.logmein.challenge.bucketedit.model.Item;
import com.logmein.challenge.bucketedit.model.OrderItem;

public interface IBucketService {
    public UUID addItemToBucket(OrderItem itemDTO);
    public void modifyItemInBucket(OrderItem itemDTO);
    public void deleteItemInBucket(String userID, UUID itemID);
    public Set<Item> getItemsOfBucket(String userID);
}
