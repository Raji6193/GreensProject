package org.junit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pom.sample.BaseClass;

public class SearchHotelPojo extends BaseClass{
	public SearchHotelPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement dropdownLocation;
	@FindBy(id="hotels")
	private WebElement dropdownHotel;
	@FindBy(id="room_type")
	private WebElement dropdownRoomType;
	@FindBy(id="room_nos")
	private WebElement dropdownRoomNos;
	@FindBy(id="datepick_in")
	private WebElement txtCheckInDate;
	@FindBy(id="datepick_out")
	private WebElement txtCheckOutDate;
	@FindBy(id="adult_room")
	private WebElement dropdownAdultCount;
	@FindBy(id="child_room")
	private WebElement dropdownChildCount;
	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	public WebElement getDropdownLocation() {
		return dropdownLocation;
	}
	public WebElement getDropdownHotel() {
		return dropdownHotel;
	}
	public WebElement getDropdownRoomType() {
		return dropdownRoomType;
	}
	public WebElement getDropdownRoomNos() {
		return dropdownRoomNos;
	}
	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}
	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}
	public WebElement getDropdownAdultCount() {
		return dropdownAdultCount;
	}
	public WebElement getDropdownChildCount() {
		return dropdownChildCount;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}

}
