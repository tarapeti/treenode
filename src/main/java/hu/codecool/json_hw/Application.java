package hu.codecool.json_hw;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<JSONObject> jsonParser(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        List<JSONObject> jsonObjects = new ArrayList<>();

        try (FileReader reader = new FileReader(fileName)) {
            Object obj = parser.parse(reader);

            JSONArray array = (JSONArray) obj;

            for (int i = 0; i < array.size(); i++) {
                jsonObjects.add((JSONObject) array.get(i));
            }


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonObjects;
    }

    public static List<TreeNode> makeTreeNodes(List<JSONObject> jsonObjects) {
        List<TreeNode> treeNodes = new ArrayList<>();
        for (JSONObject jsonObject : jsonObjects) {
            Object category = jsonObject.get("category");
            Object parent_category = jsonObject.get("parent_category");
            TreeNode treeNode = new TreeNode((String) category, (String) parent_category, null);
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }
//???
    public static void addChildNodes(List<TreeNode> treeNodes) {
        for (int i = 0; i <treeNodes.size() ; i++) {
            TreeNode current = treeNodes.get(i);
            for (int j = 1; j <treeNodes.size() ; j++) {
                TreeNode next = treeNodes.get(j);
                if (next.getParentCategory() != null && next.getParentCategory().equals(current.getCategory())){
                    current.addChildren(next);
                }else{
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        List<JSONObject> jsonObjects = jsonParser("/home/p8r/Dokumentumok/advanced/json_hw/src/main/resources/vechicles.json");
        List<TreeNode> treeNodes = makeTreeNodes(jsonObjects);
        addChildNodes(treeNodes);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode.getChildren());
        }
    }
}
