package dao;

import java.util.List;

import entity.Publisher;

public interface PublisherDao {
	
	List<Publisher> getPublishers();

	Publisher getPublisher(long id);

	void savePublisher(Publisher publisher);

	void deletePublisher(long id);

	void updatePublisher(Publisher publisher);
	
}
