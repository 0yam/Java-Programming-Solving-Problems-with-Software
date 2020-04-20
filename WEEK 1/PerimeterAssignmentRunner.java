import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
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
        // Put code here
        int num = 0;
        for (Point p : s.getPoints()) {
            num = num + 1;
        }
        
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averageLength = getPerimeter(s) / getNumPoints(s);
        
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            
            if (largestSide < currDist){
                largestSide = currDist;
            }
            
            prevPt = currPt;
        }
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestX = prevPt.getX();
        
        for (Point currPt : s.getPoints()) {
            double currPtX = currPt.getX();
            
            if (largestX < currPtX)
                largestX = currPtX;
        }
        
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            
            if (largestPerimeter < currPerimeter)
                largestPerimeter = currPerimeter;
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        File fileLargestPerimeter = null;
        
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            
            if (largestPerimeter < currPerimeter){
                largestPerimeter = currPerimeter;
                fileLargestPerimeter = f;
            }
        }

        return fileLargestPerimeter.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        // test methods getNumPoints
        int numPoints = getNumPoints(s);
        System.out.println("the number of points = " + numPoints);
        
        // test methods getAverageLength
        double averageLength = getAverageLength(s);
        System.out.println("the average of length = " + averageLength);
        
        double largestSide = getLargestSide(s);
        System.out.println("the largest side = " + largestSide);
        
        double largestX = getLargestX(s);
        System.out.println("the largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double length = getLargestPerimeterMultipleFiles();
        System.out.println("the largest perimeter = " + length);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String file = getFileWithLargestPerimeter();
        System.out.println("largest perimeter file = " + file);
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
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
