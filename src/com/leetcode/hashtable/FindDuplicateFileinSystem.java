package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guangoon on 7/17/17.
 */
public class FindDuplicateFileinSystem {
    public static class LeetFile{
        String content;
        String  path;
        String fileName;
        @Override
        public String toString(){
            return "path == " + path + ", fileName == " + fileName + ", content == " + content;
        }
    }


    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contents = new HashMap<>();

        for(String string : paths){
            List<LeetFile> leetFiles = parserPaths(string);
            for(LeetFile leetFile : leetFiles) {
                //System.out.println(leetFile.toString());
                if (contents.containsKey(leetFile.content)) {
                    contents.get(leetFile.content).add(leetFile.path + "/" + leetFile.fileName);
                }
                else{
                    List<String> cfile = new LinkedList<>();
                    cfile.add(leetFile.path + "/" + leetFile.fileName);
                    contents.put(leetFile.content, cfile);
                }
            }
        }
        List<List<String>> res = new LinkedList<>();
        for(String key : contents.keySet()){
            if(contents.get(key).size() > 1){
                res.add(contents.get(key));
            }
        }
        return res;
    }

    private List<LeetFile> parserPaths(String paths){
        if(paths == null)
            return null;
        List<LeetFile> lfiles = new LinkedList<>();
        String[] files =  paths.split(" ");
        String path = files[0];

        for(int j = 1; j < files.length; j++) {
            LeetFile file = new LeetFile();
            for (int i = 0; i < files[j].length(); i++) {
                file.path = path;
                if (files[j].charAt(i) == '(') {
                    file.fileName = files[j].substring(0, i);
                    file.content = files[j].substring(i + 1, files[j].length() - 1);
                    break;
                }
            }
            lfiles.add(file);
        }
        return lfiles;
    }
}
