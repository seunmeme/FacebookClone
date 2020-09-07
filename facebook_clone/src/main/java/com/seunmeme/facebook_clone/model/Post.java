package com.seunmeme.facebook_clone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    private Date dateCreated;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    List<Comment> comments = new ArrayList<>();
    
}
