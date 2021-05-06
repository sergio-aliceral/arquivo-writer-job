package br.com.aliceraltecnologia.arquivowriterjob.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.aliceraltecnologia.arquivowriterjob.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoWriterConfig {

	@Bean
	@StepScope
	public FlatFileItemWriter<Cliente> arquivoDelimitadoWriter(@Value("#{jobParameters['arquivoClientesSaidaDelimitado']}") Resource arquivoClientesSaidaDelimitado) {
		return new FlatFileItemWriterBuilder<Cliente>()
				.name("arquivoDelimitadoWriter")
				.resource(arquivoClientesSaidaDelimitado)
				.delimited()
				.delimiter(";")
				.names("nome", "sobrenome", "idade", "email")
				.build();
	}
}
