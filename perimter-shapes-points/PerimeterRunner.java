import edu.duke.*;
import java.io.File;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // 
        int count=0;
        for(Point p:s.getPoints()){
            count++;
               }
        
        return count;
    }

    public double getAverageLength(Shape s) {
        // 
        double result=0.0;
        result=getPerimeter(s)/getNumPoints(s);
        return result;
    }

    public double getLargestSide(Shape s) {
        // 
        Point prevPt = s.getLastPoint();
        double prevDist=0.0;
        for(Point currPt:s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist > prevDist){
                prevDist = currDist;
            }
            
        }
        return prevDist;
    }

    public double getLargestX(Shape s) {
        // 
        double larx=0.0;
       for(Point p:s.getPoints()){
               if(p.getX()>larx){
                   return larx=p.getX();
                }
            }
             return 0.0;
        }

    public double getLargestPerimeterMultipleFiles() {
        // 
        DirectoryResource dr = new DirectoryResource();
        double largPerim=0.0;
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(perimeter>largPerim){
                largPerim = perimeter;
            }
        }
        return largPerim;
    }

    public String getFileWithLargestPerimeter(){
        // 
        DirectoryResource dr = new DirectoryResource();
        File temp = null;
        double largPerim=0.0;
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(perimeter>largPerim){
                largPerim = perimeter;
                temp=f;
            }
        }
    
    
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        //
        int numpoints = getNumPoints(s);
        System.out.println("count no of points = "+numpoints);
        double avglen = getAverageLength(s);
        System.out.println("avgerage length of shape = "+avglen);
        double largeside = getLargestSide(s);
        System.out.println("largest side = "+largeside);
        System.out.println("largest X value = "+ getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // 
        double filelarPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            filelarPerim = getLargestPerimeterMultipleFiles();
        }
        System.out.println("Largest perimter using testPeriemeterMultipleFiles method:"+filelarPerim);
    }

    public void testFileWithLargestPerimeter() {
        // 
        System.out.println("Name of largest perimeter file:"+getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
