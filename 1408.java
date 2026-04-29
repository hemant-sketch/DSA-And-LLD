List<String> ans = new ArrayList<>();
        
        for (String a : words) {
            for (String b : words) {
                if (a.length() < b.length() && b.contains(a)) {
                    ans.add(a);
                    break; 
                }
            }
        }
        
        return ans;
