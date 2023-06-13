package com.example.marketing.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMarketingProjectRequest {

    @NotNull(message = "프로젝트 이름을 입력해주세요.")
    @Size(min=2,max= 30, message = "프로젝트 이름을 2자이상 30자 미만으로 입력해주세요.")
    private String projectName;
    @NotNull(message = "프로젝트 내용을 입력해주세요.")
    @Size(min=10, message = "프로젝트 내용을 10자이상 입력해주세요.")
    private String content;
}
