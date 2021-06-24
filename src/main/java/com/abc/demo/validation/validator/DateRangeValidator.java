package com.abc.demo.validation.validator;

import com.abc.demo.validation.annotation.DateRange;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String startDateFieldName;
    private String endDateFieldName;

    @Override
    public void initialize(DateRange constraintAnnotation) {
        startDateFieldName = constraintAnnotation.startDateFieldName(); // 從@DateRange取得要驗證的欄位名稱
        endDateFieldName = constraintAnnotation.endDateFieldName();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) { // value為掛有@DateRange的類別，也就是DateRangeRequestDto
            return false;
        }

        try {
            String startDateStr = BeanUtils.getProperty(object, startDateFieldName); // Apache Commons BeanUtils取得指定欄位名稱的值
            String endDateStr = BeanUtils.getProperty(object, endDateFieldName);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            return endDate.after(startDate);

        } catch (Exception e) {
            return false;
        }

    }
}
