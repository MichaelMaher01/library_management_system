package com.lms.library_management_system.service.publisher;

import com.lms.library_management_system.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface IPublisherService {
    List<Publisher> getAll();
    Optional<Publisher> getById(Long id);
    Publisher create(Publisher publisher);
    Publisher update(Long id, Publisher updatedPublisher);
    void delete(Long id);
}
