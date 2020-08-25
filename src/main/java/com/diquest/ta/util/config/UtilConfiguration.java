package com.diquest.ta.util.config;

import com.diquest.ta.util.task.step0.RetrieveDailyCallTasklet;
import com.diquest.ta.util.task.step1.TermExtractorTasklet;
import com.diquest.ta.util.task.step2.RelationKeywordTasklet;
import com.diquest.ta.util.task.step3.DocMakerTasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfiguration {

    @Bean
    public RetrieveDailyCallTasklet retrieveDailyCallTasklet() {
        return new RetrieveDailyCallTasklet();
    }

    @Bean
    public TermExtractorTasklet termExtractorTasklet() {
        return new TermExtractorTasklet();
    }

    @Bean
    public DocMakerTasklet docMakerTasklet() {
        return new DocMakerTasklet();
    }

    @Bean
    public RelationKeywordTasklet relationKeywordTasklet() {
        return new RelationKeywordTasklet();
    }
}
