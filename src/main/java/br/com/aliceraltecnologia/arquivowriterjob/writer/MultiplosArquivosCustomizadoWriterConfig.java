package br.com.aliceraltecnologia.arquivowriterjob.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.ResourceSuffixCreator;
import org.springframework.batch.item.file.builder.MultiResourceItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.aliceraltecnologia.arquivowriterjob.dominio.GrupoLancamento;

@Configuration
public class MultiplosArquivosCustomizadoWriterConfig {

	@Bean
	@StepScope
	public MultiResourceItemWriter<GrupoLancamento> multiplosArquivosCustomizadoWriter(
			@Value("#{jobParameters['multiplosArquivosCustomizado']}") Resource multiplosArquivosCustomizado,
			FlatFileItemWriter<GrupoLancamento> arquivoCustomizadoWriter) {
		return new MultiResourceItemWriterBuilder<GrupoLancamento>()
				.name("multiplosArquivosCustomizadoWriter")
				.resource(multiplosArquivosCustomizado)
				.delegate(arquivoCustomizadoWriter)
				.resourceSuffixCreator(suffixCreator())
				.itemCountLimitPerResource(1)
				.build();
	}

	private ResourceSuffixCreator suffixCreator() {
		return new ResourceSuffixCreator() {

			@Override
			public String getSuffix(int index) {
				return index + ".txt";
			}

		};
	}
}
