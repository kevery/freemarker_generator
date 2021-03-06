import freemarker.template.TemplateException;
import generate.impl.ControllerGenerator;
import uitl.FreeMarkerFacade;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kever
 * 2018/3/13
 */
public class Main {


    public static void main(String[] args) throws Exception {
        new FreeMarkerFacade("sales_refund_apply").generaterAll();
        new FreeMarkerFacade("sales_return_apply").generaterAll();
        new FreeMarkerFacade("sales_replace_apply").generaterAll();
    }


















    private static List<Map<String, String>> build() {

        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> command1 = new HashMap<>();
        command1.put("desc", "调整显示销售数量");
        command1.put("command", "AdjustShowSaleVolume");
        list.add(command1);


        Map<String, String> command2 = new HashMap<>();
        command2.put("desc", "调整库存");
        command2.put("command", "AdjustStock");
        list.add(command2);


        Map<String, String> command3 = new HashMap<>();
        command3.put("desc", "调整警戒库存");
        command3.put("command", "AdjustWarningStock");
        list.add(command3);

        Map<String, String> command4 = new HashMap<>();
        command4.put("desc", "调整售价");
        command4.put("command", "AdjustPrice");
        list.add(command4);

        Map<String, String> command5 = new HashMap<>();
        command5.put("desc", "调整商品关联标签");
        command5.put("command", "AdjustLabel");
        list.add(command5);

        return list;

    }
}
