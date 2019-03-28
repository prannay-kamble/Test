package com.margonetwork.api.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.margonetwork.api.model.Content;
import com.margonetwork.api.service.iservice.ITagService;

@RestController
@RequestMapping("/api/v1")
public class MargoNetworkEndPoint {

	@Autowired
	ITagService contentService;

	@RequestMapping(value = "/content/{tag}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Content>> getAllContentByTag(@PathVariable("tag") String tags) {

		List<Content> contentList = null;

		contentList = contentService.findContentByTag(tags);

		Link link = ControllerLinkBuilder.linkTo(MargoNetworkEndPoint.class)
				.slash(contentList.stream().findFirst().get().getContent_id()).withSelfRel();
		return new ResponseEntity<>(contentList, HttpStatus.OK);
	}

	@RequestMapping(value = "/content/{tag}/{region}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Content>> getAllContentByTagAndRegion(@PathVariable("tag") String tagName,
			@PathVariable("region") String region) {

		List<Content> contentList = null;

		contentList = contentService.findContentByTagNameAndRegion(tagName, region);

		Link link = ControllerLinkBuilder.linkTo(MargoNetworkEndPoint.class)
				.slash(contentList.stream().findFirst().get().getContent_id()).withSelfRel();
		return new ResponseEntity<>(contentList, HttpStatus.OK);
	}

}
