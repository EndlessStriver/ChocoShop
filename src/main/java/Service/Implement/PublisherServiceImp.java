package Service.Implement;

import java.util.List;

import Entity.Publisher;
import Service.PublisherService;

public class PublisherServiceImp implements PublisherService{
	
	private PublisherService publisherService;
	
	public PublisherServiceImp(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	

	@Override
	public List<Publisher> getAllPublishers() {
		try {
			return publisherService.getAllPublishers();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void createPublisher(Publisher publisher) {
		try {
			publisherService.createPublisher(publisher);
		} catch (Exception e) {
			throw e;
		}
	}
		

	@Override
	public void deletePublisher(long id) {
		try {
			publisherService.deletePublisher(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		try {
			publisherService.updatePublisher(publisher);
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public Publisher getPublisher(long id) {
		try {
			return publisherService.getPublisher(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
