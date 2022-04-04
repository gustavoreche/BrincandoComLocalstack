package com.br.awsservices;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

@SpringBootApplication
public class AwsServicesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AwsServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AWSCredentials credentials = new BasicAWSCredentials(
				  "default_access_key", 
				  "default_secret_key"
				);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withEndpointConfiguration(new EndpointConfiguration("http://localhost:4566", Regions.SA_EAST_1.getName()))
				.withPathStyleAccessEnabled(true)
				.build();
		
		
		File diretorio = new File(System.getProperty("user.dir"));
		System.out.println(diretorio);

		FileWriter arq = new FileWriter(diretorio + "/hello.txt");
		arq.close();
		
		List<Bucket> buckets = s3client.listBuckets();
		for(Bucket bucket : buckets) {
		    System.out.println(bucket.getName());
		    
			s3client.putObject(
					bucket.getName(), 
					"hello.txt", 
					new File(diretorio + "/hello.txt")
					);
		    
		}
	}

}
