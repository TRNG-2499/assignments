public Map<String, Integer> wordCount(String[] strings) {
  Map<String, Integer> map = new HashMap<>();
  for(int i = 0; i < strings.length; i++) {
    if(map.get(strings[i]) == null) {
      map.put(strings[i], 1); 
    } else {
      map.computeIfPresent(strings[i], (key, val) -> val + 1);
    }
  }
  
  return map;
}
