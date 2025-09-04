package com.internshipproject.www.Dto;


import java.util.List;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String nationality;
    private String email;
    private List<BookDto> books ;
}