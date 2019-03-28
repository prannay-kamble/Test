package com.margonetwork.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.web.bind.annotation.Mapping;

@Entity
public class MetaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "META_DATA_ID")
	private Long id;

	@Column(name = "REGION")
	private String region;

	@Column(name = "LONGSYNOPSIS")
	@Lob
	private String longSynopsis;

	@Column(name = "META_DESC")
	@Lob
	private String metaDesc;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLongSynopsis() {
		return longSynopsis;
	}

	public void setLongSynopsis(String longSynopsis) {
		this.longSynopsis = longSynopsis;
	}

	public String getMetaDesc() {
		return metaDesc;
	}

	public void setMetaDesc(String metaDesc) {
		this.metaDesc = metaDesc;
	}

}
