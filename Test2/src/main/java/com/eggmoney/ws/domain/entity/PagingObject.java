package com.eggmoney.ws.domain.entity;

import java.util.List;

/**
 * Created by dskim on 2017. 5. 8..
 */
public class PagingObject {

    public static int DEFAULT_ITEM_SIZE = 10;
    public static int DEFAULT_PAGE_ITEM_SIZE = 5;

    private int pageItemSize = DEFAULT_PAGE_ITEM_SIZE;
    private int itemSize = DEFAULT_ITEM_SIZE;

    private int currentPage;
    private int totalCount;
    @SuppressWarnings("rawtypes")
    private List resultList;

    private int comment_cnt;

    @SuppressWarnings("rawtypes")
    public List getResultList() {
        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public void setResultList(List resultList) {
        this.resultList = resultList;
    }

    public int getStartRow() {
        //return Math.max( currentPage - 1, 0 ) * itemSize+1;  // Oracle paging
        return Math.max(currentPage - 1, 0) * itemSize;	 // Mysql paging
    }

    public int getStartRowForOracle() {
        return Math.max(currentPage - 1, 0) * itemSize + 1;  // Oracle paging
    }

    public int getEndRow() {
        int endRow = Math.min(Math.max(itemSize * currentPage, 0), totalCount);
        return endRow;
    }

    public int getStartPage() {
        return currentPage - ((currentPage - 1) % itemSize);
    }

    public int getEndPage() {
        int endPage = currentPage + (itemSize - (currentPage - 1) % itemSize - 1);
        int totalPageCount = getTotalPageCount();
        return endPage > totalPageCount ? totalPageCount : endPage;
    }

    public int getTotalPageCount() {
        return totalCount % itemSize == 0 ? totalCount / itemSize : totalCount / itemSize + 1;
    }

	public static int getDEFAULT_ITEM_SIZE() {
		return DEFAULT_ITEM_SIZE;
	}

	public static void setDEFAULT_ITEM_SIZE(int dEFAULT_ITEM_SIZE) {
		DEFAULT_ITEM_SIZE = dEFAULT_ITEM_SIZE;
	}

	public static int getDEFAULT_PAGE_ITEM_SIZE() {
		return DEFAULT_PAGE_ITEM_SIZE;
	}

	public static void setDEFAULT_PAGE_ITEM_SIZE(int dEFAULT_PAGE_ITEM_SIZE) {
		DEFAULT_PAGE_ITEM_SIZE = dEFAULT_PAGE_ITEM_SIZE;
	}

	public int getPageItemSize() {
		return pageItemSize;
	}

	public void setPageItemSize(int pageItemSize) {
		this.pageItemSize = pageItemSize;
	}

	public int getItemSize() {
		return itemSize;
	}

	public void setItemSize(int itemSize) {
		this.itemSize = itemSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getComment_cnt() {
		return comment_cnt;
	}

	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}

}
