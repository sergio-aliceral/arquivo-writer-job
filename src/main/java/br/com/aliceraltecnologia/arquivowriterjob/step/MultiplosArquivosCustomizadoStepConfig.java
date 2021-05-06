package br.com.aliceraltecnologia.arquivowriterjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aliceraltecnologia.arquivowriterjob.dominio.GrupoLancamento;
import br.com.aliceraltecnologia.arquivowriterjob.reader.GrupoLancamentoReader;
import br.com.aliceraltecnologia.arquivowriterjob.writer.Rodape;

@Configuration
public class MultiplosArquivosCustomizadoStepConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step multiplosArquivosCustomizadoStep(
			GrupoLancamentoReader demonstrativoOrcamentarioReader,
			MultiResourceItemWriter<GrupoLancamento> multiplosArquivosCustomizadoWriter, 
			Rodape rodapeCallback) {
		return stepBuilderFactory
				.get("multiplosArquivosCustomizadoStep")
				.<GrupoLancamento, GrupoLancamento>chunk(1)
				.reader(demonstrativoOrcamentarioReader)
				.writer(multiplosArquivosCustomizadoWriter)
				.listener(rodapeCallback)
				.build();
	}
}
