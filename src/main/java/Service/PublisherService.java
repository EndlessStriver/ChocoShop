package Service;

import java.util.List;

import Entity.Publisher;

public interface PublisherService {
	
	List<Publisher> getAllPublishers();

	Publisher getPublisher(long id);

	void createPublisher(Publisher publisher);

	void deletePublisher(long id);

	void updatePublisher(Publisher publisher);
	
}
