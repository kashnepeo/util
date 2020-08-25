package com.diquest.ta.util.task.step3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class DocMakerTasklet {
    private final String BRACE_OPEN = "(";
    private final String BRACE_CLOSE = ")";
    private final String START_DQ_DOC = "(DQ_DOC";
    private final String END_DQ_DOC = ")DQ_DOC";
    private List<Map<String, Object>> list;

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void write(List<Object> list, String outputPath) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("")), "UTF-8"));


            for (int i = 0; i < list.size(); i++) {
                bw.append(START_DQ_DOC);
                bw.newLine();
                Map<String, String> map = (Map<String, String>) list.get(i);
                for (Map.Entry<String, String> element : map.entrySet()) {
                    String key = element.getKey();
                    String value = element.getValue();
                    bw.append(BRACE_OPEN + key);
                    bw.newLine();
                    bw.append(" " + value);
                    bw.newLine();
                    bw.append(BRACE_CLOSE + key);
                    bw.newLine();

                }
                bw.append(END_DQ_DOC);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
