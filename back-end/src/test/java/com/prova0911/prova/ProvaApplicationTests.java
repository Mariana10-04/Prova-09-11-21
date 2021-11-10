package com.prova0911.prova;

import com.prova0911.prova.model.Contatos;
import com.prova0911.prova.repository.ContatosRepository;
import com.prova0911.prova.service.ContatosService;
import com.prova0911.prova.util.Creator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ProvaApplicationTests {

	@InjectMocks
	private ContatosService service;

	@Mock
	private ContatosRepository repository;

	@BeforeEach
	void setUp() {
		when(repository.save(ArgumentMatchers.isA(Contatos.class)))
				.thenReturn(Creator.createContact());
	}

	@Test
	void shouldNotSaveDouble() {
		when(repository.findByNumber(ArgumentMatchers.anyString()))
				.thenReturn(Optional.of(Creator.createContact()));

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public class ResourceAlreadyExistsException extends RuntimeException {
		public ResourceAlreadyExistsException(String message) {
			super(message);
		}

		@Test
		public void shouldCreateContact() throws Exception {
			Contatos creator = service.creator(Creator.createContact());

			Assertions.assertThat(creator).isNotNull();
			Assertions.assertThat("Gustavo Limão").isEqualTo(creator.getNome());
			Assertions.assertThat("bombadosemfronteiras@gmail.com").isEqualTo(creator.getEmail());
			Assertions.assertThat("4540028922").isEqualTo(creator.getNumber());
		}
	}
}


