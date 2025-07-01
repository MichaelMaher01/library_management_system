package com.lms.library_management_system.service.publisher;

import com.lms.library_management_system.model.Publisher;
import com.lms.library_management_system.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements IPublisherService{

    private final PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> getById(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Publisher create(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Long id, Publisher updatedPublisher) {
        return publisherRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedPublisher.getName());
                    return publisherRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));
    }

    @Override
    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }
}
