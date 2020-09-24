package com.logmein.challenge.bucketedit.exception.handlers;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.util.StringUtils;

import com.logmein.challenge.bucketedit.exception.ValidationException;
import com.logmein.challenge.bucketedit.model.Item;
import com.logmein.challenge.bucketedit.model.OrderItem;

public class ValidationHelper {
    public final static String EMPTY_USER_ID="User ID should not be empty.";
    public final static String EMPTY_ITEM_NAME="Item Name should not be empty.";
    public final static String EMPTY_ITEM_ID="Item ID should not be empty.";
    public final static String EMPTY_ITEM_OBJECT="Item instance should not be empty.";
    public final static String NON_EMPTY_ITEM_ID="Item ID should be empty.";

    public static void validateRequestForAddItem(OrderItem orderItemDTO){
    	validateItemObject(orderItemDTO.getItem(),EMPTY_ITEM_OBJECT);
        validateItemIDForAddItem(orderItemDTO.getItem().getItemID(), NON_EMPTY_ITEM_ID);
        validateUserID(orderItemDTO.getUserID(), EMPTY_USER_ID);
        validateUserName(orderItemDTO.getItem().getItemName(), EMPTY_ITEM_NAME);
    }
    public static void validateItemObject(@NotNull @Valid Item item,String s) {
        if (item == null) {
            throw new ValidationException(s);
        }		
	}
	public static void validateRequestForModifyItem(OrderItem orderItemDTO){
	  	validateItemObject(orderItemDTO.getItem(),EMPTY_ITEM_OBJECT);
        validateItemID(orderItemDTO.getItem().getItemID(),EMPTY_ITEM_ID);
        validateUserID(orderItemDTO.getUserID(),EMPTY_USER_ID);
        validateUserName(orderItemDTO.getItem().getItemName(),EMPTY_ITEM_NAME);
    }
    public static void validateItemIDForAddItem(UUID itemID, String s) {
        if (itemID != null) {
            throw new ValidationException(s);
        }
    }

    public static void validateItemID(UUID itemID, String s) {
        if (itemID == null) {
            throw new ValidationException(s);
        }
    }
    public static void validateUserName(String itemName, String s) {
        if (StringUtils.isEmpty(itemName)) {
            throw new ValidationException(s);
        }
    }
    public static void validateUserID(String userID, String s) {
        if (StringUtils.isEmpty(userID)) {
            throw new ValidationException(s);
        }
    }
}
