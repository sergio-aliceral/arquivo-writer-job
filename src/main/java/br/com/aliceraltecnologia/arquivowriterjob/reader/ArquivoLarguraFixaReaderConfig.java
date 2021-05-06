package br.com.aliceraltecnologia.arquivowriterjob.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.aliceraltecnologia.arquivowriterjob.dominio.Cliente;

@Configuration
public class ArquivoLarguraFixaReaderConfig {

	@Bean
	@StepScope
	public FlatFileItemReader<Cliente> arquivoLarguraFixaReader(@Value("#{jobParameters['arquivoClientesLarguraFixa']}") Resource arquivoClientesLarguraFixa) {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("arquivoLarguraFixaReader")
				.resource(arquivoClientesLarguraFixa)
				.fixedLength()
				.columns(new Range[] { new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43) })
				.names(new String[] { "nome", "sobrenome", "idade", "email" })
				.targetType(Cliente.class)
				.build();
	}
}
