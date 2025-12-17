package com.Cloudflare.private_public_File_handler.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class StorageService {

    private final S3Client s3;

    @Value("${cloudflare.r2.publicBucket}")
    private String publicBucket;

    @Value("${cloudflare.r2.privateBucket}")
    private String privateBucket;

    public StorageService(S3Client s3) {
        this.s3 = s3;
    }

    public void uploadPublic(String name, byte[] data) {
        s3.putObject(
                PutObjectRequest.builder()
                        .bucket(publicBucket)
                        .key(name)
                        .build(),
                RequestBody.fromBytes(data)
        );
    }

    public void uploadPrivate(String name, byte[] data) {
        s3.putObject(
                PutObjectRequest.builder()
                        .bucket(privateBucket)
                        .key(name)
                        .build(),
                RequestBody.fromBytes(data)
        );
    }

    public byte[] downloadPrivate(String name) {
        return s3.getObjectAsBytes(
                GetObjectRequest.builder()
                        .bucket(privateBucket)
                        .key(name)
                        .build()
        ).asByteArray();
    }
}
