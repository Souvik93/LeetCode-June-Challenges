/*

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.



*/

class Solution {
    
    Map<String,PriorityQueue<String>> destinations = new HashMap<>();
    List<String> paths = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> ticket : tickets) {
            
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            if(destinations.containsKey(from)) {
                destinations.get(from).add(to);
            } else {
                PriorityQueue<String> destionationsList = new PriorityQueue<>();
                destionationsList.add(to);
                destinations.put(from,destionationsList);
            }
            
        }
        
        dfs("JFK");
        return paths;
        
    }
    
    private void dfs(String startingPoint) {
        
        PriorityQueue<String> arrivals =  destinations.get(startingPoint);
        
        while(arrivals !=null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        paths.add(0,startingPoint);
        
    }
}
