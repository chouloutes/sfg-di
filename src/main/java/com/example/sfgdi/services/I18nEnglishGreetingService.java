package com.example.sfgdi.services;

import com.example.sfgdi.repositories.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("EN")
//@Service("i18nService") //annotations are commented out since we are moving implementation to the config class
public class I18nEnglishGreetingService implements GreetingService {

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    private final EnglishGreetingRepository englishGreetingRepository;

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
