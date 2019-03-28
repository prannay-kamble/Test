package com.margonetwork.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.margonetwork.api.exception.TagNotFoundException;
import com.margonetwork.api.model.Content;
import com.margonetwork.api.repository.ITagRepository;
import com.margonetwork.api.service.iservice.ITagService;

@Service
public class TagServiceImpl implements ITagService {

	@Autowired
	ITagRepository contentRepository;

	@Override
	public List<Content> findContentByTag(String tagName) throws TagNotFoundException {
		List<Content> contentlist = new ArrayList<>();

		Pageable pageable = PageRequest.of(0, 2);

		// invoke contentRepository method
		Page<Content> listContent = contentRepository.findAllContentByTagsTagName(tagName, pageable);

		if (listContent.isEmpty()) {

			throw new TagNotFoundException("content of tag Name" + tagName + "Not Found");
		}

		listContent.forEach(content -> {
			contentlist.add(content);

		});

		return contentlist;
	}

	@Override
	public List<Content> findContentByTagNameAndRegion(String tagName, String region) throws TagNotFoundException {

		List<Content> contentlist = new ArrayList<>();
		Pageable pageable = PageRequest.of(0, 2);
		Page<Content> listContent = contentRepository.findAllContentByTagsTagNameAndMetaDataRegion(tagName, region,
				pageable);
		if (listContent.isEmpty()) {

			throw new TagNotFoundException("content of tag Name " + tagName + region + "Not Found");
		}

		listContent.forEach(content -> {
			contentlist.add(content);

		});

		return contentlist;
	}

}
