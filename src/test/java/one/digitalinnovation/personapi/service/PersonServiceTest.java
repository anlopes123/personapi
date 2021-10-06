package one.digitalinnovation.personapi.service;


import one.digitalinnovation.personapi.dto.MessageResponseDto;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;


    @Test
    void testGivenPersonDTOThenReturnSaveMessage() {
        PersonDTO personDto = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDto expectedSuccessMessage = createSuccessMessageDto(expectedSavedPerson.getId());

        MessageResponseDto successMessage = personService.createPerson(personDto);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);

    }

    private MessageResponseDto createSuccessMessageDto(Long id) {
        return MessageResponseDto
                .builder()
                .message("created person with ID " + id)
                .build();
    }
}

