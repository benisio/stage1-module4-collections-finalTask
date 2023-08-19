package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        var resultMap = new HashMap<Integer, Set<String>>();
        for (Map.Entry<String, Integer> entry : sourceMap.entrySet()) {
            var sourceMapKey = entry.getKey();
            var resultMapKey = sourceMapKey.length();
            if (resultMap.containsKey(resultMapKey)) {
                resultMap.get(resultMapKey).add(sourceMapKey);
            } else {
                var resultMapValue = new HashSet<String>();
                resultMapValue.add(sourceMapKey);
                resultMap.put(resultMapKey, resultMapValue);
            }

        }
        return resultMap;
    }
}
