package Service;

import java.util.List;

import Entity.Image;

public interface ImageService {
	
	List<Image> getImages();

	Image getImage(long id);

	void createImage(Image image);

	void deleteImage(long id);

	void updateImage(Image image);
	
}
