package com.helmes.helmes.service;

import com.helmes.helmes.dto.ApplicationCreateDto;
import com.helmes.helmes.dto.ApplicationDto;
import com.helmes.helmes.model.Application;
import com.helmes.helmes.model.Category;
import com.helmes.helmes.model.repository.ApplicationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CategoryService categoryService;
    private final ModelMapper mapper;

    public ApplicationService(ApplicationRepository applicationRepository, CategoryService categoryService, ModelMapper mapper) {
        this.applicationRepository = applicationRepository;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    public ApplicationDto create(ApplicationCreateDto dto, String token) {
        var application = mapper.map(dto, Application.class);
        application.setToken(token);
        List<Long> categoriesIds = dto.getCategories();
        Iterable<Category> categories = categoryService.findAllById(categoriesIds);
        application.setCategories((List<Category>) categories);

        Application applicationSaved = applicationRepository.save(application);
        return mapper.map(applicationSaved, ApplicationDto.class);
    }

    public List<ApplicationDto> getAllByToken(String token) {
        List<Application> applications = applicationRepository.findAllByToken(token);
        return mapper.map(applications, new TypeToken<List<ApplicationDto>>() {
        }.getType());
    }

    public ApplicationDto update(ApplicationDto dto, String token) {
        applicationRepository.findByIdAndToken(dto.getId(), token).orElseThrow();
        Application applicationUpdate = mapper.map(dto, Application.class);
        applicationUpdate.setToken(token);
        Application applicationSaved = applicationRepository.save(applicationUpdate);
        return mapper.map(applicationSaved, ApplicationDto.class);
    }
}
