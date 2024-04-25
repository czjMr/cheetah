package com.cheetah.design.statements.mode.param;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportParam {


    private Date start;

    private Date end;

    public static ReportParam defaultParam() {
        return ReportParam.builder().start(new Date()).end(new Date()).build();
    }

    public static boolean isNull(ReportParam param) {
        return Objects.isNull(param) || Objects.isNull(param.getStart()) || Objects.isNull(param.getEnd());
    }
}
