package org.openapitools;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.io.Serial;
import java.text.FieldPosition;
import java.util.Date;

@SuppressWarnings("deprecation")
public class RFC3339DateFormat extends ISO8601DateFormat {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        String value = ISO8601Utils.format(date, true);
        toAppendTo.append(value);
        return toAppendTo;
    }

}