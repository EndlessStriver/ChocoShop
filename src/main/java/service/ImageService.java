package service;

import java.util.List;

import entity.Image;

public interface ImageService {
	
	List<Image> getImages();

	Image getImage(long id);

	void createImage(Image image);

	void deleteImage(long id);

	void updateImage(Image image);
	
}
