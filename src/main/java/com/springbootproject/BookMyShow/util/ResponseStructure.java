package com.springbootproject.BookMyShow.util;

import java.util.Objects;


import lombok.Data;

@Data
public class ResponseStructure<T> 
{
    private int status;
    private String message;
    private T data;
	
    public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(data, message, status);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseStructure other = (ResponseStructure) obj;
		return Objects.equals(data, other.data) && Objects.equals(message, other.message) && status == other.status;
	}
	
	@Override
	public String toString() {
		return "ResponseStructure [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
    
    
}
