package org.flyants.chat.dto.app;

import lombok.Getter;
import lombok.Setter;
import org.flyants.chat.domain.DynamicVisibility;

import java.util.Date;
import java.util.List;

/**
 * 动态
 * @Author zhangchao
 * @Date 2019/5/24 15:10
 * @Version v1.0
 */
@Getter
@Setter
public class DynamicDto {
    private String id;
    private Date createTime;
    private String peopleId;
    private String nickName;
    private String encodedPrincipal;
    private String text;
    private List<String> images;//List<String>
    private String location;//位置
    private DynamicVisibility visibility = DynamicVisibility.ALL;
    private List<MessageUserSimpleInfoDto> assistPeopleList;//List<String>
    private Integer commentsCount;
}
