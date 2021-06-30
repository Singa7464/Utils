package cn.singa.utilexcel.excel;

import cn.singa.utilexcel.model.DataModel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义表格处理
 *
 * @author :1*+
 * Date: 2021-06-25
 */
@Slf4j
public class CustomExcelListener extends ExcelListener<DataModel> {

    @Getter
    private List<DataModel> list = new ArrayList<>();

    @Override
    protected void addAfter(DataModel t) {
        //todo 自定义实现
    }

    @Override
    protected void addBefore(DataModel t) {
        //todo 自定义实现
    }

}
