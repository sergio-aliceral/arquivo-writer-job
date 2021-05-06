package br.com.aliceraltecnologia.arquivowriterjob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ArquivoLarguraFixaJobConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Bean
	public Job arquivoLarguraFixaJob(Step leituraArquivoLarguraFixaStep) {
		return jobBuilderFactory
				.get("arquivoLarguraFixaJob")
				.start(leituraArquivoLarguraFixaStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
