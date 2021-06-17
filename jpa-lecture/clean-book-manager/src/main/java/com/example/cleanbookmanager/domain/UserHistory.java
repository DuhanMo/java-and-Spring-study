package com.example.cleanbookmanager.domain;


import com.example.cleanbookmanager.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;
}
