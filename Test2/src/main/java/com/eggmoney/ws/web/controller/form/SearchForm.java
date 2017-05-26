package com.eggmoney.ws.web.controller.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.eggmoney.ws.domain.entity.PagingObject;

public class SearchForm {


    public static enum COMMAND{
        LIST("list"),
        DETAIL("detail"),
        CREATE("create"),
        UPDATE("update"),
        DELETE("delete"),
        APPROVE("approve"),
        DENY("deny");
        private String code;
        COMMAND(String code){
            this.code = code;
        }
        public String getCode(){
            return code;
        }
        public static COMMAND getCommand(String code){
            for(COMMAND command : COMMAND.values()){
                if(StringUtils.equalsIgnoreCase(code, command.getCode())){
                    return command;
                }
            }
            return null;
        }
    }

    private String cmd;

    private int currentPage = 1;
    private String searchCondition = "";
    private String searchValue = "";

    private String searchStartDate = "";
    private String searchEndDate = "";

    private String orderBy = "";

    private int itemSize = 12;

    private PagingObject pagingObject;

    private int viewType;
    
    public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchStartDate() {
		return searchStartDate;
	}

	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public String getSearchEndDate() {
		return searchEndDate;
	}

	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getItemSize() {
		return itemSize;
	}

	public void setItemSize(int itemSize) {
		this.itemSize = itemSize;
	}

	public PagingObject getPagingObject() {
		return pagingObject;
	}

	public void setPagingObject(PagingObject pagingObject) {
		this.pagingObject = pagingObject;
	}

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public void setCommand(COMMAND command){
        setCmd(command.getCode());
    }

    public boolean isCreate(){
        return COMMAND.getCommand(getCmd()) == COMMAND.CREATE;
    }
    public boolean isUpdate(){
        return COMMAND.getCommand(getCmd()) == COMMAND.UPDATE;
    }
    public boolean isDetail(){
        return COMMAND.getCommand(getCmd()) == COMMAND.DETAIL;
    }
    public boolean isApprove(){
        return COMMAND.getCommand(getCmd()) == COMMAND.APPROVE;
    }
    public boolean isDeny(){
        return COMMAND.getCommand(getCmd()) == COMMAND.DENY;
    }

    public boolean containsSearchCondition(){
        return !StringUtils.isBlank(searchCondition) && !StringUtils.isBlank(searchValue);
    }


    public Map<String,Object> getConditionMap(){
        Map<String,Object> condition = new HashMap<String,Object>();
        if( containsSearchCondition()){
            condition.put(getSearchCondition(), getSearchValue());
        }

        if(!"".equals(getSearchStartDate())){
            condition.put("searchStartDate", getSearchStartDate());
        }
        if(!"".equals(getSearchEndDate())){
            condition.put("searchEndDate", getSearchEndDate());
        }
        //
        condition.put("searchValue", getSearchValue());

        condition.put("itemSize", getItemSize());
        condition.put("orderBy", getOrderBy());

        return condition;
    }
}
