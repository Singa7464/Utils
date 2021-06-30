package cn.singa.utilexcel.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 表格处理
 *
 * @author :1*+
 * Date: 2021-06-25
 */
@Slf4j
public class ExcelListener<T> extends AnalysisEventListener<T> {

    @Getter
    private List<T> list = new ArrayList<>();

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        addBefore(t);
        list.add(t);
        addAfter(t);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    protected void addAfter(T t) {
    }

    protected void addBefore(T t) {
    }

}
