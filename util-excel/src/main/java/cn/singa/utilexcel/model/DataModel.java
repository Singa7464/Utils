package cn.singa.utilexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 表格数据模型
 *
 * @author :1*+
 * Date: 2021-06-25
 */
@Data
public class DataModel {

    @ExcelProperty(value = "第一列", index = 0)
    private Date col1;
    @ExcelProperty(value = "第二列", index = 1)
    private Integer col2;
    @ExcelProperty(value = "第三列", index = 2)
    private String col3;

}
