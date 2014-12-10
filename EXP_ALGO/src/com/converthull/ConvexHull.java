package com.converthull;
import com.common.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ConvexHull {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Point[] Points = new Point[15];
        
        Points[0] = new Point(-5, 7);
        Points[1] = new Point(3,-6);
        Points[2] = new Point(5, 4);
        Points[3] = new Point(-5, -5);
        Points[4] = new Point(1, 7);
        Points[5] = new Point(6, 0);
        
        Points[6] = new Point(0, 0);
        Points[7] = new Point(-5, 0);
        Points[8] = new Point(3, -2);
        Points[9] = new Point(3, 4);
        
        Points[10] = new Point(1, 6);
        Points[11] = new Point(5, 3);
        Points[12] = new Point(-4, -5);
        Points[13] = new Point(-3, 6);
        Points[14] = new Point(2, 5);
    
        Arrays.sort(Points,new PointXComparator());        //Ԥ������
        
        LinkedList<Point> list = new LinkedList<Point> ();
        for(int i = 0;i < Points.length;i++)
            list.add(Points[i]);                            //list���ȫ���Ķ���
        
        LinkedList<Point> result = getConvexHulls(list);    //result����������յĽ������
        
        System.out.println("һ���� " + result.size() + " ������, " + "͹���Ķ����ǣ� ");
        Iterator it = result.iterator();
        while(it.hasNext())
        {
            Point next = (Point) it.next();
            System.out.print("(" + next.x + "," + next.y + ")" + "  " );
        }    
    }
    
    public static LinkedList<Point> getConvexHulls(LinkedList<Point> list){
        //��͹��������result������
        LinkedList<Point> result = new LinkedList<Point>(); 
        
        Point temp1 = list.removeFirst();
        Point temp2 = list.removeLast();
        result.add(temp1);
        result.add(temp2);
        
        //�ݹ�Ĵ���temp1 ---> temp2��������ĵ�
        dealWithLeft(temp1,temp2,result,list);
        dealWithLeft(temp2,temp1,result,list);//ע��ÿ��Ҫ��result���ţ���Ž����
        
        return result;
    }
    
    private static void dealWithLeft(Point p1,Point p2,LinkedList result,LinkedList list){
        //�ݹ�Ĵ���p1��p2���ɵ�������ߵĵ�
        Iterator it = list.iterator();
        
        //�ҳ������ߵĵ�Pmax
        Point Pmax = null;
        int max = 0;
        while(it.hasNext())
        {
            Point next = (Point) it.next();
            int x1 = p1.x,y1 = p1.y;
            int x2 = p2.x,y2 = p2.y;
            int x3 = next.x,y3 = next.y;
            
            //int max = 0;//СС��һ�����󰡣�������������
            int compute = x1*y2 + x3*y1 + x2*y3 - x3*y2 - x2*y1 - x1*y3;
            if(compute > max)
            {
                max = compute;
                Pmax = next;
            }    
        }
        
        //���ҵ���һ������
        if(Pmax != null)
        {
            result.add(Pmax);
            list.remove(Pmax);
            
            //�ݹ�
            dealWithLeft(p1,Pmax,result,list);
            dealWithLeft(Pmax,p2,result,list);    
        }
    }
    
    private static boolean onLeft(Point target,Point p1,Point p2){
        //�ж�target�Ƿ���p1--->p2���ߵ����
        int x1 = p1.x,y1 = p1.y;
        int x2 = p2.x,y2 = p2.y;
        int x3 = target.x,y3 = target.y;
        
        int compute = x1*y2 + x3*y1 + x2*y3 - x3*y2 - x2*y1 - x1*y3;
        if(compute > 0)
            return true;
        else
            return false;
    }
}


class PointXComparator implements Comparator<Point>{
	public int compare(Point o1,Point o2) {
		return o1.x -o2.x;
	}
}
class PointYComparator implements Comparator<Point>{
	public int compare(Point o1,Point o2) {
		return o1.y -o2.y;
	}
}