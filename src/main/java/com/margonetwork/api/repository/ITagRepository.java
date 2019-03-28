package com.margonetwork.api.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.margonetwork.api.model.Content;


public interface ITagRepository extends JpaRepository<Content, Long> {

	Page<Content> findAllContentByTagsTagName(String tagName, Pageable pageable);

	Page<Content> findAllContentByTagsTagNameAndMetaDataRegion(String tagName, String region, Pageable pageable);

}
