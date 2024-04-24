package com.study.Ex26FileUpload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CKResponse {
    private Integer uploaded;
    private String fileName;
    private String url;
}
