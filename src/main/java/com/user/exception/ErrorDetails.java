package com.user.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ErrorDetails {

	private LocalDateTime timesTamp;
	private String message;
	private String path;
	private String errorCode;
	public ErrorDetails(LocalDateTime timesTamp, String message, String path, String errorCode) {
		super();
		this.timesTamp = timesTamp;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getTimesTamp() {
		return timesTamp;
	}
	public void setTimesTamp(LocalDateTime timesTamp) {
		this.timesTamp = timesTamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
