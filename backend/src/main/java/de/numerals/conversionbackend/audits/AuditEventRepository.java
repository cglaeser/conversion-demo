package de.numerals.conversionbackend.audits;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditEventRepository extends MongoRepository<AuditEvent, String> {
    AuditEvent findById(UUID id);
}
