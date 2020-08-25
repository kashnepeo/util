package com.diquest.ta.util.task.step1;


import com.diquest.disa.DISA;
import com.diquest.jiana.core.result.Eoj;
import com.diquest.jiana.core.result.Morph;
import com.diquest.jiana.core.result.PosTag;
import com.diquest.jiana.hdic.DQTagDic;
import com.diquest.jiana.result.JianaResult;
import com.diquest.plot.result.PLOTResult;

import java.io.File;
import java.util.*;

public class TermExtractorTasklet extends DISA {
    private final static String filePath = File.separator;
    private Map<String, String> tagMap;
    private List<Map<String, Object>> list;

    public TermExtractorTasklet() {

    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void init() {
        String dicHome = "C:" + filePath + "Users" + filePath + "Dell" + filePath + "Downloads" + filePath + "sts-3.9.7.RELEASE" + filePath + "gs-rest-service" + filePath + "initial" + filePath + "m4" + filePath + "resources" + filePath;
        String jianaDicPath = dicHome + "jiana" + filePath + "dic" + filePath + "korean" + filePath + "dcd" + filePath;
        String plotDicPath = dicHome + "plot" + filePath + "dic" + filePath + "korean" + filePath + "dcd" + filePath;
        String disaDicPath = dicHome + "disa" + filePath + "dic" + filePath + "korean" + filePath + "dcd" + filePath;
//		String dicHome = "/tap/dq_demo/gs-rest-server/resources/";
//		String jianaDicPath = dicHome + "jiana/dic/korean/dcd/";
//		String plotDicPath = dicHome + "plot/dic/korean/dcd/";
//		String disaDicPath = dicHome + "disa/dic/korean/dcd/";
        String category = "SUBWAY_STATION";
        this.init(disaDicPath, plotDicPath, jianaDicPath, category);

        tagMap = new HashMap<String, String>();
        tagMap.put("ncn", "일반명사");
        tagMap.put("ncp", "일반명사");
    }

    public List<String> getJianaResultStr(String line) {
        if (line.length() > 9) {
            this.analyze(line.toCharArray());
            PLOTResult plotResult = this.getPLOTResult();
            JianaResult jianaResult = plotResult.getJianaResult();

            Eoj eoj = jianaResult.getEoj();
            Morph morph = jianaResult.getMorph();
            PosTag posTag = jianaResult.getTag();

            int eojStart = 0, eojEnd;

            List<String> list = new ArrayList<String>();
            List<Integer> idxList = new ArrayList<Integer>();

            for (int i = 0; i < eoj.getCount(); i++) {
                eojEnd = eoj.getMorphOfEojEnd(i);

                for (int j = eojStart; j <= eojEnd; j++) {
                    String morphStr = new String(morph.getData(j));
                    String posTagStr = DQTagDic.tag.main.getName(posTag.getTag(j));
                    String tempMorphStr = j + "_" + morphStr;

                    list.add(morphStr + ": " + posTagStr);
                    idxList.add(j);

                }
                eojStart = eojEnd + 1;
            }
            return list;
        } else {
            return Collections.emptyList();
        }
    }
}
