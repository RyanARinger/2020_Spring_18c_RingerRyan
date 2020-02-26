
package classwork_022520;

/**
 *
 * @author Ryan Ringer
 */
public abstract class Block implements Renderable{
    private int x;
    private int y;
    private int z;
    
    private String name;
    protected String textureName = "null";
    
    
    public void setX(int xC){
        this.x = xC;
    }
    public void setY(int yC){
        this.y = yC;
    }
    public void setZ(int zC){
        this.z = zC;
    }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getZ(){
        return this.z;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String n){
        this.name = n;
    }
    
    @Override
    public void render(){
        
    }
    
    @Override
    public void setTextureName(String n){
        
    }
    
    @Override
    public String getTextureName(){
        return this.textureName;
    }
}
