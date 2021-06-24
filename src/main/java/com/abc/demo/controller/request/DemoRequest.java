package com.abc.demo.controller.request;

import com.abc.demo.validation.annotation.DateRange;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@DateRange(startDateFieldName = "startDate", endDateFieldName = "endDate")
public class DemoRequest {

    @Positive
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endDate;

}
