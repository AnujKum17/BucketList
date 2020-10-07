package com.logmein.challenge.bucketedit.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.logmein.challenge.bucketedit.exception.ItemAlreadyExistsException;
import com.logmein.challenge.bucketedit.exception.ObjectNotFoundException;
import com.logmein.challenge.bucketedit.model.Item;
import com.logmein.challenge.bucketedit.model.OrderItem;

@Service
public class BucketService implements IBucketService{
    private static final Map<String, HashSet<Item>> bucket= new ConcurrentHashMap<String, HashSet<Item>>();
    private static final Logger log = LoggerFactory.getLogger(BucketService.class);

    @Override
    public UUID addItemToBucket(OrderItem itemDTO) {
        return addNewItemToBucket(itemDTO, bucket.get(itemDTO.getUserID()));
    }

    @Override
    public void modifyItemInBucket(OrderItem orderItemDTO){
        Set<Item> itemDTOList = bucket.get(orderItemDTO.getUserID());
        if (CollectionUtils.isEmpty(itemDTOList)){
            throw new ObjectNotFoundException("No bucket list exists for user : " + orderItemDTO.getUserID());
        }else{
        	HashSet<Item> itemsSet = new HashSet<Item>();
            itemDTOList.forEach(item ->{
                if (item.equals(orderItemDTO.getItem())){
                	itemsSet.add(orderItemDTO.getItem());
                }else {
                	itemsSet.add(item);
                }
            });
            bucket.put(orderItemDTO.getUserID(), itemsSet);
            itemDTOList = null;
        }
    }

    @Override
    public void deleteItemInBucket(String userID,UUID itemID) {
        HashSet<Item> itemDTOList = bucket.get(userID);
        if (CollectionUtils.isEmpty(itemDTOList)){
            throw new ObjectNotFoundException("No bucket list exists for user : " + userID);
        }else{
        HashSet<Item> newItemDTOList = new HashSet<Item>();
        itemDTOList.forEach(item ->{
            if (!item.getItemID().equals(itemID)){
            	newItemDTOList.add(item);
            }
        });
        bucket.put(userID, newItemDTOList);
        itemDTOList = null;
        }
    }

    @Override
    public Set<Item> getItemsOfBucket(String userID) {
        return bucket.get(userID);
    }

    private UUID addNewItemToBucket(OrderItem orderItemDTO, HashSet<Item> itemsSet) {
        final UUID itemID = UUID.randomUUID();
        if (itemsSet == null || itemsSet.isEmpty()){
        	log.info("Creating bucket for user");
            HashSet<Item> newItemsSet = new HashSet<Item>();
            newItemsSet.add(orderItemDTO.getItem());
            orderItemDTO.getItem().setItemID(itemID);
            bucket.put(orderItemDTO.getUserID(),newItemsSet);
        }
        else{
            if(itemsSet.contains(orderItemDTO.getItem())) throw new ItemAlreadyExistsException("Item already exists in the bucket of " + orderItemDTO.getUserID());
            itemsSet.add(orderItemDTO.getItem());
            orderItemDTO.getItem().setItemID(itemID);
           }
		return itemID;
        }
}
