package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;
@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	@Mock
	ItemRepository repository;
	@InjectMocks
	ItemBusinessService business;
	@Test
	void testRetreiveHardcodedItem() {
		ItemBusinessService businessService = new ItemBusinessService();//arrange
		Item item = businessService.retreiveHardcodedItem();//act
		when(repository.save(item)).thenReturn(item);
		Item saved = business.saveItem(item);
		//when(repository.Equals(item)).thenReturn(if(saved.getName().equals("Ball"))return true;);
		
		//Item item2=new Item(1, "Ball",10,100);
		
		//assertEquals(new Item(1, "Ball",10,100),item);
		//boolean ans=business.Check(item);
	}
	
	@Test
	void testSaveItems() {
		Item item = new Item(2,"Item3",20,30);
		when(repository.save(item)).thenReturn(item);
		Item saved = business.saveItem(item);
		assertEquals("Item3",saved.getName());
		assertNotNull(item.getId());
	}
	
@Test
void testNoName() {
	Item item = new Item(5,"",20,30);
	when(repository.save(item)).thenReturn(item);
	Item saved = business.saveItem(item);
	assertEquals("",saved.getName());
	assertNotNull(item.getName());

}


//	when(repository.save(item)).thenReturn(item);
//	Item saved = business.saveItem(item);
//	assertEquals("",saved.getName());




	@Test
	void testRetrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item",20,20),new Item(3,"Item3",20,20)));
		business.retrieveAllItems();
		}
	
	@Test
	void testRetrieveAllItemsWithZeroItems() {
		when(repository.findAll()).thenReturn(Arrays.asList());
		business.retrieveAllItems();
		}

}
