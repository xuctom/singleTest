package com.migu.redstone.order.service.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.migu.redstone.dto.Header;
/**
 * PushListMsgReq
 * 6.1.5手机号群推消息模板接口
 * @author wfl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushListMsgReq {
    /**
     * 公共请求头
     */
    @Valid
    @NotNull(message = "参数requestHeader不能为空")
    private Header requestHeader;
    /**
     * 分省id,用于区分消息来自哪个分省
     */
    @NotBlank(message = "参数provinceId不能为空")
    @Length(max = 3, message = "provinceId字段长度最长3")
    private String provinceId;
    /**
     * 消息批次号,用于区分一条消息的推送
     */
    @NotBlank(message = "参数batchId不能为空")
    @Length(max = 128, message = "batchId字段长度最长128")
    private String batchId;
    /**
     * 消息ID,推送平台内的消息ID
     */
    @Length(max = 128, message = "msgId字段长度最长128")
    private String msgId;
    /**
     * 号码包文件名,根据/provinceId/fileName.txt到ftp目录下找到指定文件
     */
    @NotBlank(message = "参数fileName不能为空")
    @Length(max = 256, message = "fileName字段长度最长256 ")
    private String fileName;
    /**
     * 时间戳
     */
    @NotBlank(message = "参数timestamp不能为空")
    @Length(max = 14, message = "timestamp字段长度最长14")
    private String timestamp;

    /**
     * 定时发送时间
     */
    @Length(max = 19, message = "startTime字段长度最长19")
    private String startTime;
}
