package com.dog.empire.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TrackingEntity  implements Serializable{
   
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;

    @CreatedDate
//    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", nullable = false)
    @JsonIgnore
    private Date timestamp;
    

    @PrePersist
    private void onCreate() {
        timestamp = new Date();
    }
    
    @LastModifiedDate
    @CreatedDate
//    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastModifiedDate")
    @JsonIgnore
    private Date lastModifiedDate;

}
