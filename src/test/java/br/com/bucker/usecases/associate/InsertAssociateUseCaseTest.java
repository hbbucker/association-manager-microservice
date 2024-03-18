package br.com.bucker.usecases.associate;

import br.com.bucker.adpters.postgres.AssociateModel;
import br.com.bucker.domain.associate.AssociateEntity;
import br.com.bucker.ports.database.associate.AssociateRepository;
import br.com.bucker.usecases.associate.insert.InsertAssociateException;
import br.com.bucker.usecases.associate.insert.InsertAssociateUseCase;
import br.com.bucker.usecases.associate.insert.dto.input.InsertAssociateUseCaseInputDTO;
import br.com.bucker.usecases.associate.insert.dto.output.InsertAssociateUseCaseOutupuDTO;
import br.com.bucker.usecases.associate.translate.AssociateUseCaseMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@QuarkusTest
class InsertAssociateUseCaseTest {

    @Mock
    AssociateRepository<AssociateModel> repository;

    @Mock
    AssociateUseCaseMapper mapper;

    InsertAssociateUseCase usecase;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        usecase = new InsertAssociateUseCase(repository, mapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void should_execute_usecase() throws InsertAssociateException {
        InsertAssociateUseCaseInputDTO associateInput = InserAssociateUseCaseHelper
                .createInput();
        AssociateEntity associate = InserAssociateUseCaseHelper
                .createDomainFromInput(associateInput);
        AssociateModel associateModel = InserAssociateUseCaseHelper
                .createModelFromDomain(associate);

        InsertAssociateUseCaseOutupuDTO associateOutput = InsertAssociateUseCaseOutupuDTO
                .builder()
                .build();

        //when(translate.toModel(associate)).thenReturn(associateModel);
        //when(translate.toDomain(associateInput)).thenReturn(associate);
        //when(translate.toOutput(associate)).thenReturn(associateOutput);

        InsertAssociateUseCaseOutupuDTO output = usecase.execute(associateInput);

        verify(repository).save(any(AssociateModel.class));
        assertNotNull(output);
    }

    @Test
    void should_validate_usecase_without_address() {
        InsertAssociateUseCaseInputDTO associateInput = InserAssociateUseCaseHelper
                .createInputWihoutAddress();
        AssociateEntity associate = InserAssociateUseCaseHelper
                .createDomainFromInput(associateInput);
        AssociateModel associateModel = InserAssociateUseCaseHelper
                .createModelFromDomain(associate);

        InsertAssociateUseCaseOutupuDTO associateOutput = InsertAssociateUseCaseOutupuDTO
                .builder()
                .build();

        //when(translate.toModel(associate)).thenReturn(associateModel);
        //when(translate.toDomain(associateInput)).thenReturn(associate);
        //when(translate.toOutput(associate)).thenReturn(associateOutput);

        InsertAssociateException exception = assertThrows(InsertAssociateException.class,
                () -> usecase.execute(associateInput));

        verify(repository, never()).save(any(AssociateModel.class));
        assertEquals("associate.insert.error", exception.getKey());
        assertEquals("Associate is not valid", exception.getMessage());
        assertEquals("[{\"domain\":\"street\",\"message\":\"Address is required\"}]", exception.getErrors());
    }

    @Test
    void should_validate_usecase_whithout_documents() {
        InsertAssociateUseCaseInputDTO associateInput = InserAssociateUseCaseHelper
                .createInputWihoutDocuments();
        AssociateEntity associate = InserAssociateUseCaseHelper
                .createDomainFromInput(associateInput);
        AssociateModel associateModel = InserAssociateUseCaseHelper
                .createModelFromDomain(associate);

        InsertAssociateUseCaseOutupuDTO associateOutput = InsertAssociateUseCaseOutupuDTO
                .builder()
                .build();

        //when(translate.toModel(associate)).thenReturn(associateModel);
        //when(translate.toDomain(associateInput)).thenReturn(associate);
        //when(translate.toOutput(associate)).thenReturn(associateOutput);

        InsertAssociateException exception = assertThrows(InsertAssociateException.class,
                () -> usecase.execute(associateInput));

        verify(repository, never()).save(any(AssociateModel.class));
        assertEquals("associate.insert.error", exception.getKey());
        assertEquals("Associate is not valid", exception.getMessage());
        assertEquals("[{\"domain\":\"document\",\"message\":\"Documents is required\"}]", exception.getErrors());
    }
}