package com.messier219.mantis_viewer.bug;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 버그 서비스
 * @author messier219
 */
@Service
@RequiredArgsConstructor
public class BugService {

    private final BugMapper bugMapper;

    /**
     * 전체 버그 조회
     * @return 버그 리스트
     */
    @Transactional(rollbackFor = Exception.class)
    public List<Bug> getBugs() {
        List<Bug> bugList = bugMapper.findAll();

        for (Bug bug : bugList) {
            
            // 담당자 할당 확인
            String handlerId = bug.getHandlerId();
            if(!StringUtils.hasLength(handlerId)) {
                bug.setHandlerId("없음");
                bug.setHandlerName("없음");
            }
        }

        return bugList;
    }
}
