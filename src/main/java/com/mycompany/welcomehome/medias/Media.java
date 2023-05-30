package com.mycompany.welcomehome.medias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Media {
	@Id
	private String id;
    private String name;
    private String type;
    private long size;
    private String url;

    public Media(String name, String type, long size, String url) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public Media() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    

    public long getSize() {
        return size;
    }

    
    public String getUrl() {
        return url;
    }

    
}
