package com.logmein.challenge.bucketedit.api;

import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.logmein.challenge.bucketedit.model.Item;
import com.logmein.challenge.bucketedit.model.OrderItem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-20T10:43:42.587Z[GMT]")
@Api(value = "bucket")
public interface IBucketApi {
	
    @ApiOperation(value = "Adds an item to an user bucket list", nickname = "addItem", notes = "Adds an item to the user bucket list", response = UUID.class, tags={ "Add item to an user bucket list.", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Item added to user bucket list.", response = UUID.class),
            @ApiResponse(code = 400, message = "Invalid item."),
            @ApiResponse(code = 409, message = "An item already exists in the user bucket.") })
    @RequestMapping(value = "/add/item",
            produces = { "text/plain", "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" },
            method = RequestMethod.POST)
    
    ResponseEntity<UUID> addItem(@ApiParam(value = "Item to add to the user bucket list"  )  @Valid @RequestBody OrderItem body);
    
    @ApiOperation(value = "Delete an item from an user bucket list.", nickname = "deleteItem", notes = "Delete an item from an user bucket list", tags={ "Delete an item from an user bucket list.", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item deleted from the user bucket list."),
            @ApiResponse(code = 400, message = "Invalid input parameter.") })
    @RequestMapping(value = "/delete/user/{userID}/item/{itemID}",
    		consumes = { "application/json", "application/xml", "text/plain"},
            method = RequestMethod.DELETE)
    
    ResponseEntity<Void> deleteItem(@NotNull @ApiParam(value = "User ID whose item is to be deleted from  user bucket list", required = true) @Valid @PathVariable(value = "userID", required = true) String userID
            ,@NotNull @ApiParam(value = "Item ID to be deleted from user bucket list", required = true) @Valid @PathVariable(value = "itemID", required = true) UUID itemID);

    @ApiOperation(value = "Retrieve all items of an user bucket list.", nickname = "retrieveItems", notes = "Retrieve all items of an user bucket list.", response = Item.class, responseContainer = "List", tags={ "Retrieve all the items of an user bucket.", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of items of an user bucket", response = Item.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid input parameter") })
    @RequestMapping(value = "/get/items/{userID}",
            produces = { "application/json", "application/xml", "text/plain" },
            method = RequestMethod.GET)
    
    ResponseEntity<Set<Item>> getItems(@ApiParam(value = "User ID whose bucket list needs to be returned",required=true) @PathVariable("userID") String userID);
    
    @ApiOperation(value = "Modify an item of an user bucket.", nickname = "modifyItem", notes = "Modify an item of an user bucket.", tags={ "Modify an item of an user bucket.", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item of an user bucket modified."),
            @ApiResponse(code = 400, message = "Invalid input parameter.") })
    @RequestMapping(value = "/modify/item",
            consumes = { "application/json", "application/xml", "text/plain"},
            method = RequestMethod.PUT)
    
    ResponseEntity<Void> modifyItem(@ApiParam(value = "Item to be modified in the user bucket list"  )  @Valid @RequestBody OrderItem body);

}
