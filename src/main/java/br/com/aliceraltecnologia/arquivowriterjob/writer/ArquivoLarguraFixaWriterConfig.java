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
public class ArquivoLarguraFixaWriterConfig {

	@Bean
	@StepScope
	public FlatFileItemWriter<Cliente> arquivoLarguraFixaWriter(@Value("#{jobParameters['arquivoClientesSaidaLarguraFixa']}") Resource arquivoClientesSaidaLarguraFixa) {
		return new FlatFileItemWriterBuilder<Cliente>()
				.name("arquivoLarguraFixaWriter")
				.resource(arquivoClientesSaidaLarguraFixa)
				.formatted()
				.format("%-9s %-9s %-2s %-19s")
				.names("nome", "sobrenome", "idade", "email")
				.build();
	}
}
