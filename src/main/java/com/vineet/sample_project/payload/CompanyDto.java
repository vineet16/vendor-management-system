package com.vineet.sample_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {
    private int id;
    private String CIN_No;
    private String name;
    private String phone_no;
    private String email;
    private String GST_no;

}
