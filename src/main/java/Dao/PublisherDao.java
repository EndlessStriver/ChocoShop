package Dao;

import java.util.List;

import Entity.Publisher;

public interface PublisherDao {
	
	List<Publisher> getPublishers();

	Publisher getPublisher(long id);

	void savePublisher(Publisher publisher);

	void deletePublisher(long id);

	void updatePublisher(Publisher publisher);
	
}
