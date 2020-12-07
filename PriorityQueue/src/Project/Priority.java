package Project;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.*;
public class Priority{
    public static void main(String[] args) {

        
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        while (true) {
        System.out.println("Nhap vao lua chon 1  : them phan tu ");
        System.out.println("Nhap vao lua chon 2  : thay the phan tu ");
        System.out.println("Nhap vao lua chon 3  : xoa  phan tu ");
        System.out.println("Nhap vao lua chon 4  : tim kiem phan tu ");
        System.out.println("Nhap vao lua chon 5  : Duyet Queue ");
        System.out.println("Nhap vao lua chon 6  : exit ");
        System.out.println("Nhap vao lua chon  : ");
        Scanner nhap = new Scanner(System.in);
        int choose = nhap.nextInt();
        
        switch (choose) {    
        case 1:
            System.out.println("Nhap vao phan tu them vao Queue");
            Scanner nhap1 = new Scanner(System.in);
            int addNew = nhap1.nextInt();
            numbers.add(addNew); // thêm phần tử vào priority queue
        
            
            break;  
        case 2:    
        	  System.out.println("Nhap vao phan tu muon thay the  cua  Queue");
              Scanner nhap2 = new Scanner(System.in);
              int replace = nhap2.nextInt();
              numbers.remove(replace);  // xóa một phần tử chỉ định khỏi priority queue
              System.out.println("Nhap vao phan tu moi cua  Queue");
              Scanner nhap5 = new Scanner(System.in);
              int offerNew = nhap5.nextInt();
              numbers.offer(offerNew); // chức năng như add nhưng trả về false thay vì exception khi không thể chèn phần tử
            break; 
      
        case 3:    
        	  System.out.println("Nhap vao phan tu muon xoa cua Queue");
              Scanner nhap3 = new Scanner(System.in);
              int removeItem = nhap3.nextInt();
              numbers.remove(removeItem);
            break; 
            
        case 4:
        	Object[] arr = numbers.toArray();   // convert priority queue to array
        	  

    		Integer[] integerArray = new Integer[arr.length]; // copied array


    		for (int i = 0; i < arr.length; i++)
    			integerArray[i] = (Integer)arr[i];
        	
            System.out.println("Nhap vao phan tu muon tim kiem");
            Scanner nhap4 = new Scanner(System.in);
            int find = nhap4.nextInt();
            for (int j = 0; j < integerArray.length; j++) 
                if (integerArray[j] == find )
                System.out.println(integerArray[j]); 
                else 
                	System.out.println("Khong tim thay ");
        	break;
        	
        case 5:     
//          Iterator<Integer> iterate = numbers.iterator();
//          while(iterate.hasNext()) {
//              System.out.print(iterate.next());
//              int a = iterate.next();
//              System.out.print(a);
//              
//          if (iterate.next() == 1) {
//             	 System.out.println();
//             }
//             System.out.print(", ");
//         }
        	System.out.print(numbers + "/n");
        	break;
        case 6:       	
        	break;
        default:     
          break;
        }   
        }
//        numbers.add(4);
//        numbers.add(2);
       // System.out.println("PriorityQueue: " + numbers);

        
//        numbers.offer(1);
//        
      //  boolean result = numbers.remove(4);
       // System.out.println("Is the element 2 removed? " + result);
        
        

      
        
        
    }
}