package br.com.aliceraltecnologia.arquivowriterjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aliceraltecnologia.arquivowriterjob.dominio.GrupoLancamento;
import br.com.aliceraltecnologia.arquivowriterjob.reader.GrupoLancamentoReader;

@Configuration
public class ArquivoCustomizadoStepConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step arquivoCustomizadoStep(
			GrupoLancamentoReader grupoLancamentoReader,
			ItemWriter<GrupoLancamento> arquivoCustomizadoWriter) {
		return stepBuilderFactory
				.get("demonstrativoOrcamentarioStep")
				.<GrupoLancamento, GrupoLancamento>chunk(100)
				.reader(grupoLancamentoReader)
				.writer(arquivoCustomizadoWriter)
				.build();
	}

}
