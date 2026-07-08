import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    ArrayList<Pan> list= new ArrayList<>();
	    for(int i=0;i<4;i++){
	        int id=sc.nextInt();sc.nextLine();
	        String material=sc.nextLine();
	        String brand=sc.nextLine();
	        double price=sc.nextDouble();
	        int capacity=sc.nextInt();sc.nextLine();
	        list.add(new Pan(id,material,brand,price,capacity));
	    }
	    String mat=sc.nextLine();
	    String bra=sc.nextLine();
	    int res=high(list,mat);
	    double dis=discount(list,bra);
	    System.out.println(res);
	    System.out.printf("%.2f%n",dis);
	}
	public static int high(ArrayList<Pan>list,String mat)
	{   double max=-1;
	int id=-1;
	    for(Pan p:list)
	    {
	        if(p.getmaterial().equalsIgnoreCase(mat))
	        {
	           if(max<p.getprice())
	           {
	               max=p.getprice();
	               id=p.getid();
	           }
	        }
	    }
	    return id;
	}
	public static double discount(ArrayList<Pan>list,String dis)
	{  double dp=0.0;
	    for(Pan p:list)
	    {
	        if(p.getbrand().equalsIgnoreCase(dis))
	        {
	          double price=p.getprice();
	          int cap=p.getcapacity();
	          double disc=0;
	          if(cap<=1000)
	          {
	              disc=10;
	          }
	          if(cap<=2000)
	          {
	              disc=15;
	          }
	          else{
	              disc=20;
	          }
	          double newp=price-(price*disc/100.0);
	          return newp;
	        }
	        
	    }
	    return 0.0;
	}
}
class Pan {
    private int id;
    private String material;
    private String brand;
    private double price;
    private int capacity;
    public Pan (int id,String material,String brand,double price,int capacity)
    {
        this.id=id;
        this.material=material;
        this.brand=brand;
        this.price=price;
        this.capacity=capacity;
        
    }
    public int getid()
    {
        return id;
    }
    public void setid(int id)
    {
        this.id=id;
    }
    public String getmaterial()
    {
        return material;
        
    }
    public void setmaterial(String material)
    {
        this.material=material;
    }
    public String getbrand()
    {
        return brand;
    }
    public void setbrand(String brand)
    {
        this.brand=brand;
    }
    
    public double getprice()
    {
        return price;
    }
    public void setprice(double price)
    {
        this.price=price;
        
    }
    public int getcapacity()
    {
        return capacity;
    }
    public void setcapacity(int capacity)
    {
        this.capacity=capacity;
    }
    
}
