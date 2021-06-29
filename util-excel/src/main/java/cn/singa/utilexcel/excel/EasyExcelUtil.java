package cn.singa.utilexcel.excel;

import com.alibaba.excel.EasyExcelFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

/**
 * alibaba Easy Excel封装工具类
 *
 * @author :1*+
 * Date: 2021-06-28
 */
@Slf4j
public class EasyExcelUtil {


    private static final String EXCEL_REGULAR = "^.*\\.xls.?$";

    /**
     * 读Excel
     *
     * @param clazz    数据模型
     * @param filePath 文件路径
     * @return 数据集合
     */
    public static List readExcel(Class clazz, String filePath) {
        if (notExcelFile(filePath)) {
            log.warn("读取文件非excel文件:{}", filePath);
            throw new IllegalExcelException(filePath);
        }
        File file = new File(filePath);
        if (!file.exists()) {
            log.error("读取文件不存在:{}", filePath);
            throw new IllegalExcelException(filePath);
        }

        ExcelListener readListener = new ExcelListener();
        EasyExcelFactory.read(file, clazz, readListener).sheet(0).doRead();
        return readListener.getList();
    }

    /**
     * 删除excel文件
     *
     * @param fileName 文件名
     */
    public static void delExcel(String fileName) {
        if (notExcelFile(fileName)) {
            log.warn("删除文件非excel文件:{}", fileName);
            return;
        }
        Path filePath = Paths.get(fileName);
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException ioe) {
            log.error("删除excel文件失败:{}", ExceptionUtils.getStackTrace(ioe));
        }

    }

    /**
     * 判断是否是excel文件
     *
     * @param fileName 文件名
     * @return true  or false
     */
    private static boolean notExcelFile(String fileName) {
        return !Pattern.matches(EXCEL_REGULAR, fileName);
    }


    public static class IllegalExcelException extends RuntimeException {

        public IllegalExcelException(String message) {
            super(message);
        }


        @Override
        public String getMessage() {
            return "非法Excel文件:" + super.getMessage();
        }
    }


}
