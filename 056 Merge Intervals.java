Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

题目的意思是要求合并有交集的序列。办法是先将list进行排序，然后再进行操作。
主要是用到了Collections.sort()方法。以及Comparator接口。


public class Solution {
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

