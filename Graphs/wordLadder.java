class Solution {
    public static class Pair {
        String word;
        int dist;

        Pair(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }

    public boolean isEdge(String a, String b) {
        int diff = 0;
        for (int idx = 0; idx < a.length(); idx++) {
            if (a.charAt(idx) != b.charAt(idx)) { 
                diff++;
            }
        }
        return diff == 1; 
    }

    public int ladderLength(String src, String dest, List<String> dict) {
        if (!dict.contains(dest)) return 0; 
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1)); 

        HashMap<String, Integer> dist = new HashMap<>(); 
        
        while (!q.isEmpty()) {
            Pair p = q.remove();
            
            if (dist.containsKey(p.word)) continue;
            if (p.word.equals(dest)) return p.dist;
            
            dist.put(p.word, p.dist);
            
            for (String nbr : dict) { 
                if (isEdge(p.word, nbr)) { 
                    q.add(new Pair(nbr, p.dist + 1));
                }
            }
        }
        return 0;
    }
}
