package Service.Implement;

import java.util.List;

import Dao.ImageDao;
import Entity.Image;
import Service.ImageService;

public class ImageServiceImp implements ImageService{
	
	private ImageDao imageDao;
	
	public ImageServiceImp(ImageDao imageDao) {
        this.imageDao = imageDao;
	}

	@Override
	public List<Image> getImages() {
		try {
			return imageDao.getImages();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Image getImage(long id) {
		try {
			return imageDao.getImage(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void createImage(Image image) {
		try {
			imageDao.createImage(image);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteImage(long id) {
		try {
			imageDao.deleteImage(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateImage(Image image) {
		try {
            imageDao.updateImage(image);
        } catch (Exception e) {
            throw e;
        }
	}

}
