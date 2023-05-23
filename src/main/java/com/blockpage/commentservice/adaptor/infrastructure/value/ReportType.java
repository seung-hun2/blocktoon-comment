package com.blockpage.commentservice.adaptor.infrastructure.value;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportType {
    SPAM(0, "스팸/도배 신고"),
    PORNOGRAPHIC(1, "음란물 신고"),
    ABUSE(2, "욕설 신고"),
    ILLEGAL(3, "불법 정보 신고"),
    PRIVACY(4, "개인정보 노출 신고"),
    UNPLEASANT(5, "불쾌한 표현 신고");

    private int key;
    private String value;

    public static ReportType findReportTypeByKey(int key) {
        return Arrays.stream(ReportType.values())
            .filter(t -> t.getKey() == key)
            .findFirst().get();
    }

}
