// package closestpair;

// import java.util.*;

// public class closestPairPoints {

//     public static class Point {
//         private double x;
//         private double y;

//         public Point(double x, double y) {
//             this.x = x;
//             this.y = y;
//         }

//     }

//     private double closestPair_TotalRuntime, linearClosestPair_TotalRuntime;

//     private ArrayList<Point> Point = new ArrayList<>();

//     // return milisecond
//     public double nanoToMili(long startTimes, long endTimes) {
//         return (double) (endTimes - startTimes) / 1000000;
//     }
    
//     public closestPairPoints(ArrayList<Point> Point) {
//         this.Point = Point;
//     }

//     public double closestPair() {
//         long startTime = System.nanoTime();
//         ArrayList<Point> Points =  new ArrayList<>(this.Point);

//         int num_point = Points.size(); // So diem

//         // Kiem tra input P co it nhat 2 diem tren mat phang
//         if (Points == null || Points.size() < 2) {
//             System.out.println("P is a set of at least two points on the plane, given by their x-and y-coordinates");
//             return -1;
//         }
 
//         // Point P = new Point();
//         // Copy cac diem trong mang points --> P_x va P_y
//         Point[] P_x = new Point[num_point];
//         Point[] P_y = new Point[num_point];

//         for (int i = 0; i < num_point; i++) {
//             P_x[i] = Points.get(i);
//             P_y[i] = Points.get(i);
//         }

//         // Sort Array x-coordinate
//         Arrays.sort(P_x, new Comparator<Point>() {
//             @Override
//             public int compare(Point p1, Point p2) {
//                 return Double.compare(p1.x, p2.x);
//             }
//         });
        
//         // Sort Array x-coordinate
//         Arrays.sort(P_x, new Comparator<Point>() {
//             @Override
//             public int compare(Point p1, Point p2) {
//                 return Double.compare(p1.y, p2.y);
//             }
//         });

//         Point[] B = new Point[num_point];
//         long stopTime = System.nanoTime();
//         Double min_dict =  RCP(P_x, P_y, B, 0, num_point - 1);
//         closestPair_TotalRuntime = nanoToMili(startTime , stopTime);
//         return min_dict;
//     }

    

//     private double RCP(Point[] P_x, Point[] P_y, Point[] B, int lo, int hi) {
//         Point p1 = null, p2 = null;
//         double min = Double.MAX_VALUE;
//         // Dieu kien dung
//         if (hi <= lo) return Double.POSITIVE_INFINITY;

//         if(P_x.length <= 3){
//             return getDistance(P_x[0], P_x[0]);
//         }

//         int mid = lo + (hi - lo) / 2;
//         Point X_m = P_x[mid];

//         // SubList cua ca mang trai vai phai
//         double L_x = RCP(P_x, P_y, B, lo, mid);
//         double R_x = RCP(P_x, P_y, B, mid + 1, hi);
//         double phi = Math.min(L_x, R_x);

//         // B[0..m-1] = Các điểm trong khoảng có tọa độ x từ m-phi tới m + phi và được xắp theo Y
//         int m = 0;
//         for (int i = lo; i <= hi; i++) {
//             if (Math.abs(P_y[i].x - X_m.x) < phi)
//                 B[m++] = P_y[i];
//         }
//         // so sánh từng điểm với các điểm lân cận của nó với tọa độ y gần hơn phi
//         for (int i = 0; i < m; i++) {
//             // Vong for nay se lạp 7 lan
//             for (int j = i + 1; (j < m) && (B[j].y - B[i].y < phi); j++) {
//                 double distance = getDistance(B[i], B[j]);
//                 if (distance < phi) {
//                     phi = distance;
//                     if (distance < min) {
//                         min = phi;
//                         p1 = B[i];
//                         p2 = B[j];
//                     }
//                 }
//             }
//         }
//         return phi;
//     }


//     // Thuat toan tim 2 canh gan nhat bang cach so sanh tuan tu
//     public Double linearClosestPair(){
//         long startTime = System.nanoTime();
//         ArrayList<Point> Points =  new ArrayList<>(this.Point);
//         double min = Double.MAX_VALUE;
//         int n = Points.size();
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 double distance = getDistance(Points.get(i), Points.get(j));
//                 if(min>distance){
//                     min = distance;
//                 }
//             }
//         }
//         Double min_dis =  min;
//         long stopTime = System.nanoTime();
//         linearClosestPair_TotalRuntime = nanoToMili(startTime , stopTime);
//         return min_dis;
//     }



//     public double getDistance(Point a, Point b) {
//         double x = a.x - b.x;
//         double y = a.y - b.y;
//         return Math.sqrt(x * x + y * y);
//     }


//     // Return
//     public double closestPair_getTotalRuntime() {
//         return closestPair_TotalRuntime;
//     }
    
//     public double linearClosestPair_getTotalRuntime() {
//         return linearClosestPair_TotalRuntime;
//     }

//     public static void main(String[] args) {
//         ArrayList<Point> list = new ArrayList<>();
//         Random rd = new Random();
//         for (int i = 0; i < 5; i++) {
//             Point p1 = new Point(100 * rd.nextDouble() ,100 * rd.nextDouble());
//             list.add(p1);
//         }
//         // Point p1 = new Point(2,3);
//         // Point p2 = new Point(12,30);
//         // Point p3 = new Point(40,50);
//         // Point p4 = new Point(5,1);
//         // Point p5 = new Point(12,10);
//         // Point p6 = new Point(3,4);
//         // list.add(p1);  list.add(p2); list.add(p3); list.add(p4); list.add(p5); list.add(p6);

//         for (int j = 0; j < list.size(); j++) {
//             System.out.println(list.get(j).x + "  " + list.get(j).y);
//         }
        
//         closestPairPoints m = new closestPairPoints(list);

//         System.out.println(" Min1 " + m.linearClosestPair());
//         System.out.println(" time1 " + m.linearClosestPair_getTotalRuntime());

//         for (int j = 0; j < list.size(); j++) {
//             System.out.println(list.get(j).x + "  " + list.get(j).y);
//         }
//         System.out.println(" Min2 " + m.closestPair());
//         System.out.println(" time2 " + m.closestPair_getTotalRuntime()); 
       
//     }
// }
