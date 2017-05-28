package com.eggmoney.ws.domain.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data public class Board {
	private long cno;
	private String subject;
	private String summary;
	private String contents;
	private String tags;
	private String file_name;
	private String file_path;
	private String file_name_org;
	private long view_cnt;
	private long like_cnt;
	private long zzim_cnt;
	private String thumbnail;
	private String thumbnail_app;
	private long creater;
	private long updater;
	private Date create_date;
	private Date update_date;
	private MultipartFile attached_file;
}
