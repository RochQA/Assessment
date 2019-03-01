package com.qa.test;

public class Constants {
	public static final String FILELOCATION = "C:\\Users\\Admin\\Desktop\\AssessmentFriday.xlsx";
	public static final String url = "http://35.246.41.31:8080/";
	public static final String user = "admin";
	public static final String password = "admin";
	
	public static final String userInput ="//*[@id=\"j_username\"]";
	public static final String passwordInput ="/html/body/div/div/form/div[2]/input";
	public static final String signInButton ="/html/body/div/div/form/div[3]/input";
	
	public static final String newItemLink = "//*[@id=\"tasks\"]/div[1]/a[2]";
	public static final String newItemNameInput = "//*[@id=\"name\"]";
	public static final String newItemName = "TestItem";
	public static final String freestyleProject = "//*[@id=\"j-add-item-type-standalone-projects\"]/ul/li[1]";	
	public static final String okButton ="//*[@id=\"ok-button\"]";
	public static final String saveButton = "//*[@id=\"yui-gen38-button\"]";
	public static final String dashboardLink = "//*[@id=\"tasks\"]/div[1]/a[1]";
	public static final String itemClass = ".job-status-nobuilt";
	public static final String nameClass = ".model-link.inside";
	
	public static final String manageLink = "//*[@id=\"tasks\"]/div[4]/a[2]";
	public static final String manageUsers = "//*[@id=\"main-panel\"]/div[16]/a";
	public static final String createUser = "//*[@id=\"tasks\"]/div[3]/a[1]";
	
	public static final String createUsernameInput ="//*[@id=\"username\"]";
	public static final String createPassInput ="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input";
	public static final String createConfirmPassInput ="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input";
	public static final String createFullNameInput ="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input";
	public static final String createEmailInput ="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input";
	public static final String createUserButton ="//*[@id=\"yui-gen1-button\"]";
	
	public static final String peopleLink ="//*[@id=\"tasks\"]/div[2]/a[2]";
	public static final String idSort="//*[@id=\"people\"]/tbody/tr[1]/th[2]/a";
	public static final String userName="//*[@id=\"people\"]/tbody/tr[2]/th[3]/a";

}