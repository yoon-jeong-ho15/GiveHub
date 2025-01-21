package kh.GiveHub.image.model.service;

import org.springframework.stereotype.Service;

import kh.GiveHub.image.model.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
	private final ImageMapper mapper;
}
