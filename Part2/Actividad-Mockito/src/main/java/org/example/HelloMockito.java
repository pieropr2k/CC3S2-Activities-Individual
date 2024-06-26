package org.example;

import java.util.Optional;

public class HelloMockito {
    private String greeting = "Hello, %s, from Mockito!";
    // Dependencies
    private final PersonRepository personRepository;
    private final TranslationService translationService;
    // Constructor to inject the dependencies
    public HelloMockito(PersonRepository personRepository, TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }
    // Method we want to test
    public String greet(int id, String sourceLang, String targetLang) {
        String name;
        try {
            Optional<Person> person = personRepository.findById(id);
            name = person.map(Person::getFirst).orElse("World");
            return translationService.translate(String.format(greeting, name), sourceLang, targetLang);
        } catch (Exception e) {
            return "Error occurred while retrieving the person";
        }
    }
}