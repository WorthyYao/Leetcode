Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


这道题是56题的加强版，但是感觉没有任何变化。如果是插入操作的话，在集合中插入一个新的Interval，然后再进行
merge操作。其实也就是调用56题的源码。


public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res=new ArrayList<>();
        if(intervals.size()==0){
            res.add(newInterval);
            return res;
        }
        intervals.add(newInterval);
        res=merge(intervals);

        return res;
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()<=1){
            return intervals;
        }
        Collections.sort(intervals,new IntervalComparator());
        List<Interval> res=new ArrayList<Interval>();
        Interval last=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval curr=intervals.get(i);
            if(curr.start<=last.end){
                last.end=Math.max(last.end,curr.end);
            }else {
                res.add(last);
                last=curr;
            }
        }
        res.add(last);
        return res;
    }

    public class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a,Interval b){
            return a.start-b.start;
        }
    }
}