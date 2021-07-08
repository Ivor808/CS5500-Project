package com.CS5500.springbootinfrastructure.formatter;

import java.sql.Timestamp;

public interface DataFormatter {
    Timestamp convertTimestamp(String unformattedDate);
}
