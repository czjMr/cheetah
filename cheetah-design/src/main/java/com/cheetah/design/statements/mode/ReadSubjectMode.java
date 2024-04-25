package com.cheetah.design.statements.mode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReadSubjectMode {

    private String stageName;

    private String stageCode;

    private String subjectCode;

    private String subjectName;



}
