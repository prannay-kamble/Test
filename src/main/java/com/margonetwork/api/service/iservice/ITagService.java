package com.margonetwork.api.service.iservice;

import java.util.List;

import org.springframework.data.domain.Page;

import com.margonetwork.api.exception.TagNotFoundException;
import com.margonetwork.api.model.Content;
import com.margonetwork.api.model.Tags;

public interface ITagService {

	public List<Content> findContentByTag(String tags) throws TagNotFoundException;

	public List<Content> findContentByTagNameAndRegion(String tagNAme, String region) throws TagNotFoundException;

}
