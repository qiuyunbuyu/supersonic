package com.tencent.supersonic.headless.api.pojo.request;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;

import java.util.Objects;

@Data
@ToString
public class QuerySqlReq extends SemanticQueryReq {
    private String sql;

    @Override
    public String toCustomizedString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append("\"dataSetId\":")
                .append(dataSetId);
        stringBuilder.append("\"modelIds\":")
                .append(modelIds);
        stringBuilder.append(",\"params\":")
                .append(params);
        stringBuilder.append(",\"cacheInfo\":")
                .append(cacheInfo);
        stringBuilder.append(",\"sql\":")
                .append(sql);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean needGetDataSetId() {
        return (Objects.isNull(this.getDataSetId()) || this.getDataSetId() <= 0)
                && (CollectionUtils.isEmpty(this.getModelIds()));
    }
}
