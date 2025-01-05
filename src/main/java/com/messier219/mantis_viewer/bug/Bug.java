package com.messier219.mantis_viewer.bug;

import lombok.Getter;
import lombok.Setter;

/**
 * 버그 VO
 */
@Getter
@Setter
public class Bug {
    private int rowNumber; // 순서
    private String projectName; // 프로젝트 이름
    private String categoryName; // 카테고리 이름
    private String summary; // 제목
    private int status; // 상태
    private String reporterId; // 보고자 ID
    private String reporterName; // 보고자 이름
    private String handlerId; // 담당자 ID
    private String handlerName; // 담당자 이름
    private String dateSubmitted; // 등록일시
}
