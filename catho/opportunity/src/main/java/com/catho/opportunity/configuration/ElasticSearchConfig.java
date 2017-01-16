package com.catho.opportunity.configuration;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.catho.opportunity.model.Job;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
@Configuration
public class ElasticSearchConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @Value("${elasticsearch.endpoint}")
    private String elasticSearchInstance;

    @Value("${elasticsearch.port}")
    private Integer elasticSearchPort;
    
    @Value("${elasticsearch.index.settings_jobs}")
    private String settingsPath;
    
    @Value("${elasticsearch.index.mapping_jobs}")
    private String mappingPath;
    
    @Bean
    public Client getClient() throws UnknownHostException {
        @SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticSearchInstance), elasticSearchPort));
        verifyJobs(client);
        return client;
    }

    private void verifyJobs(TransportClient client) {
        createGenericIndex(client, Job.INDEX_NAME, Job.INDEX_TYPE, settingsPath, mappingPath);
    }
    
    private void createGenericIndex(TransportClient client, String indexName, String indexType, String settingsPath, String mappingPath) {
        try {
            IndicesExistsRequest request = new IndicesExistsRequest(indexName);
            client.admin().indices().exists(request, new ActionListener<IndicesExistsResponse>() {
                public void onResponse(IndicesExistsResponse response) {
                    if (response.isExists()) {
                        LOGGER.info("[x] Index " + indexName + " already existis!");
                    } else {
                        try {
                            FileInputStream settingsInputStream = new FileInputStream(settingsPath);
                            String mapping = new String(Files.readAllBytes(Paths.get(mappingPath)));

                            client.admin().indices().prepareCreate(indexName)
                                    .setSettings(Settings.builder().loadFromStream(settingsPath, settingsInputStream))
                                    .addMapping(indexType, mapping)
                                    .get();

                            LOGGER.info("[+] Index " + indexName + " created with success!");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    e.printStackTrace();
                    LOGGER.error("Failure: " + e.getMessage(), e);
                }
            });
        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage(), e);
        }
    }
}
